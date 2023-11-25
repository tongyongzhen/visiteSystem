package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import visite_system.demo.Entity.User;
import visite_system.demo.Entity.VipAppointment;
import visite_system.demo.Entity.VipExamine;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.VIP_AppointmentMapper;
import visite_system.demo.Mapper.VIP_ExamineMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.VIPService;


@Service
public class VIPServiceImpl implements VIPService {

    @Autowired
    private VIP_AppointmentMapper vipAppointmentMapper;

    @Autowired
    private VIP_ExamineMapper vipExamineMapper;

    @Autowired
    private QrCodeUtils qrCodeUtils;

    @Override
    public Result vipAppoint(VipAppointment vipAppointment) {
        //获取登录人员信息
        User user = ThreadLocalUtil.get();
        vipAppointment.setVisiteEmployeeId(user.getId());
        //存入数据库
        vipAppointmentMapper.insert(vipAppointment);
        //获取id
        LambdaQueryWrapper<VipAppointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(VipAppointment::getCarnum,vipAppointment.getCarnum());
        VipAppointment one = vipAppointmentMapper.selectOne(wrapper);
        Long appointmentId = one.getId();
        VipExamine vipExamine = VipExamine.builder().appointmentId(appointmentId).build();
        vipExamineMapper.insert(vipExamine);
        return Result.ok();
    }

    @Override
    public Result vipExamine(VipExamine vipExamine) {
        //全部都同意
        if(!ObjectUtils.isEmpty(vipExamine.getManageOpinion())
                && !ObjectUtils.isEmpty(vipExamine.getManageId())){
            String qrCode = qrCodeUtils.createQrCode(String.valueOf(vipExamine.getId()));
            vipExamine.setCode(qrCode);
        }
        vipExamineMapper.insert(vipExamine);
        return Result.ok();

    }

    @Override
    public Result vipVisiteEnd(Long id) {
        LambdaUpdateWrapper<VipExamine> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(VipExamine::getAppointmentId,id);
        VipExamine vipExamine = vipExamineMapper.selectOne(wrapper);
        vipExamine.setIsgo(0);
        vipExamineMapper.updateById(vipExamine);
        return Result.ok();
    }
}
