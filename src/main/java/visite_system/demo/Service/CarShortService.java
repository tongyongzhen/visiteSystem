package visite_system.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import visite_system.demo.Entity.CarShortAppointment;
import visite_system.demo.Pojo.Result;

public interface CarShortService{
    Result carShortAppoint(CarShortAppointment carShortAppointment);
}
