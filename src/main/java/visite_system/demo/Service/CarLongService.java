package visite_system.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Pojo.Result;

public interface CarLongService {
    Result carLongAppoint(CarLongAppointment carLongAppointment);
}
