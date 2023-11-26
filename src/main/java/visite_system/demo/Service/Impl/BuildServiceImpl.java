package visite_system.demo.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import visite_system.demo.Entity.BuildAppointment;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.Build_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.BuildService;

import java.util.Date;

@Service
public class BuildServiceImpl implements BuildService {
    @Autowired
    private Build_AppointmentMapper buildAppointmentMapper;

    @Autowired
    private QrCodeUtils qrCodeUtils;

    @Override
    public Result buildAppoint(BuildAppointment buildAppointment) {
        User user = ThreadLocalUtil.get();
        buildAppointment.setUserId(user.getId());
        buildAppointment.setAppointTime(new Date());
        buildAppointmentMapper.insert(buildAppointment);
        return Result.ok();
    }

    @Override
    public Result buildExamine(BuildAppointment buildAppointment) throws Exception {
        Long appointmentId = buildAppointment.getId();
        if(ObjectUtils.isEmpty(appointmentId)){
            throw new Exception("没有预约的id");
        }
        BuildAppointment appointment = buildAppointmentMapper.selectById(appointmentId);
        User user = ThreadLocalUtil.get();
        appointment.setExaminerId(user.getId());
        Integer isagree = buildAppointment.getIsagree();
        appointment.setIsagree(isagree);
        //生成二维码
        if(isagree==0){
            String qrCode = qrCodeUtils.createQrCode(String.valueOf(appointment.getId()));
            appointment.setCode(qrCode);
        }
        buildAppointmentMapper.updateById(appointment);
        return Result.ok();
    }
}
