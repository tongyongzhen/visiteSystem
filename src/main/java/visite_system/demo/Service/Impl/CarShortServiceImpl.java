package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarLongRecord;
import visite_system.demo.Entity.CarShortAppointment;
import visite_system.demo.Entity.CarShortRecord;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.CarShort_AppointmentMapper;
import visite_system.demo.Mapper.CarShort_RecordMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CarShortService;

import java.io.File;
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
    public Result carShortAppoint(CarShortAppointment carShortAppointment) {
        User user = ThreadLocalUtil.get();
        carShortAppointment.setUserId(user.getId());
        carShortAppointmentMapper.insert(carShortAppointment);
        LambdaQueryWrapper<CarShortAppointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CarShortAppointment::getUserId,user.getId());
        CarShortAppointment one = carShortAppointmentMapper.selectOne(wrapper);
        //生成二维码
        String qrCode = qrCodeUtils.createQrCode(String.valueOf(one.getId()));
        one.setCode(qrCode);
        carShortAppointmentMapper.insert(one);
        return Result.ok(one);
    }

    @Override
    public Result carShortPictureUp(Long id, MultipartFile multipartFile) {
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
            CarShortRecord carShortRecord = carShortRecordMapper.selectById(id);
            carShortRecord.setPicture(newFileName);
            carShortRecord.setCameramanId(user.getId());
            carShortRecordMapper.updateById(carShortRecord);
            //返回提示信息
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500,e.getMessage());
        }
    }

    @Override
    public Result carShortPictureExamine(CarShortRecord carShortRecord) {
        User user = ThreadLocalUtil.get();
        carShortRecord.setExamineId(user.getId());
        carShortRecordMapper.updateById(carShortRecord);
        return Result.ok();
    }

    @Override
    public Result carShortBaoAnExamine(CarShortRecord carShortRecord) {
        User user = ThreadLocalUtil.get();
        carShortRecord.setBaoanId(user.getId());
        carShortRecordMapper.updateById(carShortRecord);
        return Result.ok();
    }

}
