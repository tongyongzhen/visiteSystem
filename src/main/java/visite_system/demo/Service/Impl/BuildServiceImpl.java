package visite_system.demo.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.BuildAppointment;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.Build_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.BuildService;

@Service
public class BuildServiceImpl implements BuildService {
    @Autowired
    private Build_AppointmentMapper buildAppointmentMapper;

    @Override
    public Result buildAppoint(BuildAppointment buildAppointment) {
        User user = ThreadLocalUtil.get();
        buildAppointment.setUserId(user.getId());
        buildAppointmentMapper.insert(buildAppointment);
        return Result.ok();
    }
}
