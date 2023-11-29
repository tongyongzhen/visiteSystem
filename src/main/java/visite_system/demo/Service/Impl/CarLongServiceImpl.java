package visite_system.demo.Service.Impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Entity.CarLongRecord;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.CarLong_AppointmentMapper;
import visite_system.demo.Mapper.CarLong_RecordMapper;
import visite_system.demo.Pojo.CarPicture;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CarLongService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CarLongServiceImpl implements CarLongService {

    @Autowired
    private CarLong_AppointmentMapper carLongAppointmentMapper;

    @Autowired
    private QrCodeUtils qrCodeUtils;

    @Autowired
    private CarLong_RecordMapper carLongRecordMapper;



    @Override
    public Result carLongAppoint() throws Exception {
        User user = ThreadLocalUtil.get();
        LambdaQueryWrapper<CarLongAppointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CarLongAppointment::getUserId,user.getId());
        CarLongAppointment one = carLongAppointmentMapper.selectOne(wrapper);
        if(!ObjectUtils.isEmpty(one)){
            throw new Exception("当前用户已登记");
        }
        CarLongAppointment carLongAppointment = new CarLongAppointment();
        carLongAppointment.setUserId(user.getId());
        carLongAppointment.setAppointTime(new Date());
        carLongAppointmentMapper.insert(carLongAppointment);
        //获取id
        //生成二维码
        one = carLongAppointmentMapper.selectOne(wrapper);
        String qrCode = qrCodeUtils.createQrCode(String.valueOf(one.getId()));
        one.setCode(qrCode);
        carLongAppointmentMapper.updateById(one);
        CarLongRecord carLongRecord = CarLongRecord.builder().appointmentId(one.getId()).build();
        carLongRecordMapper.insert(carLongRecord);

        return Result.ok(one);
    }

    @Override
    public Result carLongPictureUp(CarPicture carPicture) {
        Long id = carPicture.getId();
        CarLongRecord carLongRecord = carLongRecordMapper.selectById(id);
        //获取base64编码
        String base64 = carPicture.getImage();
        //组装
        String picture="data:image/png;base64,"+base64;
        carLongRecord.setPicture(picture);
        carLongRecordMapper.updateById(carLongRecord);
        return Result.ok();
    }

    @Override
    public Result carLongPictureExamine(CarLongRecord carLongRecord) {
        User user = ThreadLocalUtil.get();
        carLongRecord.setExamineId(user.getId());
        LambdaUpdateWrapper<CarLongRecord> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(CarLongRecord::getExamineId,user.getId())
                .set(CarLongRecord::getExamineResult,carLongRecord.getExamineResult());
        carLongRecordMapper.update(carLongRecord,wrapper);
        return Result.ok();
    }

    @Override
    public Result carLongBaoAnExamine(CarLongRecord carLongRecord) {
        User user = ThreadLocalUtil.get();
        carLongRecord.setExamineId(user.getId());
        carLongRecordMapper.updateById(carLongRecord);
        return Result.ok();
    }

    @Override
    public Result queryLongPictureById(Long id) {
        CarLongRecord carLongRecord = carLongRecordMapper.selectById(id);
        return Result.ok(carLongRecord.getPicture());
    }
}
