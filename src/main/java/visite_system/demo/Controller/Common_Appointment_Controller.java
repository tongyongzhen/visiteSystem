package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import visite_system.demo.Entity.CommonAppointment;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.Common_AppointmentService;

@RestController
@RequestMapping("/Appointment")
@Validated
@Api("普通访客预约接口")
public class Common_Appointment_Controller {

    @Autowired
    private Common_AppointmentService commonAppointmentService;
    @RequestMapping("/CommonAppoint")
    @ApiOperation("普通访客预约")
    public Result commonAppoint(@RequestBody CommonAppointment commonAppointment){
        return commonAppointmentService.commonAppoint(commonAppointment);

    }
}
