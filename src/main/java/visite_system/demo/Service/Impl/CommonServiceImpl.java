package visite_system.demo.Service.Impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import visite_system.demo.Entity.CommonAppointment;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.ImageUtils;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.Common_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CommonService;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private Common_AppointmentMapper commonAppointmentMapper;

    @Autowired
    private QrCodeUtils qrCodeUtils;

    @Override
    public Result commonAppoint(CommonAppointment commonAppointment) {
        //获取登录用户信息
        User user = ThreadLocalUtil.get();
        Long userId = user.getId();
        commonAppointment.setUserId(userId);
        commonAppointment.setAppointTime(new Date());
        //存入数据库
        int insert = commonAppointmentMapper.insert(commonAppointment);
        return Result.ok();
    }

    @Override
    public Result commonExamine(CommonAppointment commonAppointment) throws Exception {
        User user = ThreadLocalUtil.get();
        if(ObjectUtils.isEmpty(commonAppointment.getId())){
            throw new Exception("未传入id");
        }
        CommonAppointment commonAppointment1 = commonAppointmentMapper.selectById(commonAppointment.getId());
        Integer isagree = commonAppointment.getIsagree();
        commonAppointment1.setIsagree(isagree);
        //同意，生成二维码
            if(isagree==0){
                String qrCode = qrCodeUtils.createQrCode(String.valueOf(commonAppointment1.getId()));
                commonAppointment1.setCode(qrCode);
            }
        commonAppointmentMapper.updateById(commonAppointment1);
        return Result.ok(commonAppointment1);
    }

    @Override
    public Result commonVisiteEnd(Long id) throws Exception {
        CommonAppointment commonAppointment = commonAppointmentMapper.selectById(id);
        if(ObjectUtils.isEmpty(commonAppointment)){
            throw new Exception("预约id不存在");
        }
        if(commonAppointment.getIsagree()!=0){
            throw new Exception("该预约未同意");
        }
        commonAppointment.setIsgo(0);
        commonAppointmentMapper.updateById(commonAppointment);
        return Result.ok();
    }
}
