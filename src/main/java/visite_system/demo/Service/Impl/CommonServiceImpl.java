package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.CommonAppointment;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.Common_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private Common_AppointmentMapper commonAppointmentMapper;

    @Override
    public Result commonAppoint(CommonAppointment commonAppointment) {
        //获取登录用户信息
        User user = ThreadLocalUtil.get();
        Long userId = user.getId();
        commonAppointment.setUserId(userId);
        //存入数据库
        int insert = commonAppointmentMapper.insert(commonAppointment);
        return Result.ok();
    }

    @Override
    public Result commonExamine(CommonAppointment commonAppointment) {
        System.out.println(commonAppointment);
        return Result.ok();
    }
}
