package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.User;
import visite_system.demo.Entity.VipAppointment;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.VIP_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.VIPService;


@Service
public class VIPServiceImpl implements VIPService {

    @Autowired
    private VIP_AppointmentMapper vipAppointmentMapper;
    @Override
    public Result vipAppoint(VipAppointment vipAppointment) {
        //获取登录人员信息
        User user = ThreadLocalUtil.get();
        vipAppointment.setVisiteEmployeeId(user.getId());
        //存入数据库
        vipAppointmentMapper.insert(vipAppointment);
        return Result.ok();
    }
}
