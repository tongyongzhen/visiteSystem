package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.CarLong_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CarLongService;

@Service
public class CarLongServiceImpl implements CarLongService {

    @Autowired
    private CarLong_AppointmentMapper carLongAppointmentMapper;

    @Override
    public Result carLongAppoint(CarLongAppointment carLongAppointment) {
        User user = ThreadLocalUtil.get();
        carLongAppointment.setUserId(user.getId());
        carLongAppointmentMapper.insert(carLongAppointment);
        return Result.ok();
    }
}
