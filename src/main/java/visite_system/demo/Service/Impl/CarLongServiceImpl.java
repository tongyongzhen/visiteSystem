package visite_system.demo.Service.Impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Entity.CarLongRecord;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.CarLong_AppointmentMapper;
import visite_system.demo.Mapper.CarLong_RecordMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CarLongService;

import java.io.File;
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
    public Result carLongPictureUp(Long id,MultipartFile multipartFile) {
        User user = ThreadLocalUtil.get();
        //获取文件名
        String fileName = multipartFile.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片，写到需要保存的目录下
        String filePath = "E:\\ProjectStudy\\";
        String newFileName=filePath+fileName;
        try {
            //将图片保存到static文件夹里
            multipartFile.transferTo(new File(newFileName));
            CarLongRecord carLongRecord = carLongRecordMapper.selectById(id);
            carLongRecord.setPicture(newFileName);
            carLongRecord.setCameramanId(user.getId());
            carLongRecordMapper.updateById(carLongRecord);
            //返回提示信息
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500,e.getMessage());
        }

    }

    @Override
    public Result carLongPictureExamine(CarLongRecord carLongRecord) {
        User user = ThreadLocalUtil.get();
        carLongRecord.setExamineId(user.getId());
        carLongRecordMapper.updateById(carLongRecord);
        return Result.ok();
    }

    @Override
    public Result carLongBaoAnExamine(CarLongRecord carLongRecord) {
        User user = ThreadLocalUtil.get();
        carLongRecord.setExamineId(user.getId());
        carLongRecordMapper.updateById(carLongRecord);
        return Result.ok();
    }
}
