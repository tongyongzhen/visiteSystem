package visite_system.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import visite_system.demo.Entity.CommonAppointment;
import visite_system.demo.Pojo.Result;

public interface Common_AppointmentService extends IService<CommonAppointment> {

    Result commonAppoint(CommonAppointment commonAppointment);
}
