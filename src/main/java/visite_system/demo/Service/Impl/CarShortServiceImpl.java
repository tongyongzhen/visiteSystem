package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarLongRecord;
import visite_system.demo.Entity.CarShortAppointment;
import visite_system.demo.Entity.CarShortRecord;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.CarShort_AppointmentMapper;
import visite_system.demo.Mapper.CarShort_RecordMapper;
import visite_system.demo.Pojo.CarPicture;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CarShortService;

import java.io.File;
import java.util.Date;
import java.util.UUID;

@Service
public class CarShortServiceImpl implements CarShortService {

    @Autowired
    private CarShort_AppointmentMapper carShortAppointmentMapper;

    @Autowired
    private CarShort_RecordMapper carShortRecordMapper;


    @Autowired
    private QrCodeUtils qrCodeUtils;
    @Override
    public Result carShortAppoint(CarShortAppointment carShortAppointment) throws Exception {
        User user = ThreadLocalUtil.get();
        LambdaQueryWrapper<CarShortAppointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CarShortAppointment::getUserId,user.getId());
        CarShortAppointment one = carShortAppointmentMapper.selectOne(wrapper);
        if(!ObjectUtils.isEmpty(one)){
            throw new Exception("当前账号已登记");
        }
        carShortAppointment.setUserId(user.getId());
        carShortAppointment.setAppointTime(new Date());
        carShortAppointmentMapper.insert(carShortAppointment);
        one = carShortAppointmentMapper.selectOne(wrapper);
        //生成二维码
        String qrCode = qrCodeUtils.createQrCode(String.valueOf(one.getId()));
        one.setCode(qrCode);
        carShortAppointmentMapper.updateById(one);
        CarShortRecord carShortRecord = CarShortRecord.builder()
                .appointmentId(one.getId())
                .build();
        carShortRecordMapper.insert(carShortRecord);
        return Result.ok(one);
    }

    @Override
    public Result carShortPictureUp(CarPicture carPicture) {
        Long id = carPicture.getId();
        CarShortRecord carShortRecord = carShortRecordMapper.selectById(id);
        //获取base64编码
        String base64 = carPicture.getImage();
        //组装
        String picture="data:image/png;base64,"+base64;
        carShortRecord.setPicture(picture);
        carShortRecordMapper.updateById(carShortRecord);
        return Result.ok();
    }

    @Override
    public Result carShortPictureExamine(CarShortRecord carShortRecord) {
        User user = ThreadLocalUtil.get();
        CarShortRecord carShortRecord1 = carShortRecordMapper.selectById(carShortRecord.getId());
        carShortRecord1.setExamineId(user.getId());
        carShortRecord1.setExamineResult(carShortRecord.getExamineResult());
        carShortRecordMapper.updateById(carShortRecord1);
        return Result.ok();
    }

    @Override
    public Result carShortBaoAnExamine(CarShortRecord carShortRecord) {
        User user = ThreadLocalUtil.get();
        CarShortRecord carShortRecord1 = carShortRecordMapper.selectById(carShortRecord.getId());
        carShortRecord1.setBaoanId(user.getId());
        carShortRecord1.setBaoanResult(carShortRecord.getBaoanResult());
        carShortRecord1.setGoTime(new Date());
        carShortRecordMapper.updateById(carShortRecord1);
        return Result.ok();
    }

    @Override
    public Result queryShortPictureById(Long id) {
        CarShortRecord carShortRecord = carShortRecordMapper.selectById(id);
        return Result.ok(carShortRecord.getPicture());
    }

}
