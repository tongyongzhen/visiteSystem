package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import visite_system.demo.Entity.*;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Appointment")
@Validated
@Api("预约接口")
public class Appointment_Controller {

    @Autowired
    private CommonService commonAppointmentService;

    @Autowired
    private VIPService vipAppointmentService;

    @Autowired
    private CarLongService carLongAppointmentService;

    @Autowired
    private CarShortService carShortAppointmentService;

    @Autowired
    private BuildService buildService;


    @RequestMapping("/CommonAppoint")
    @ApiOperation("普通访客预约")
    public Result commonAppoint(@RequestBody @Valid CommonAppointment commonAppointment){
        return commonAppointmentService.commonAppoint(commonAppointment);

    }

    @RequestMapping("/VIPAppoint")
    @ApiOperation("VIP访客预约")
    public Result vipAppoint(@RequestBody @Valid VipAppointment vipAppointment){
        return vipAppointmentService.vipAppoint(vipAppointment);

    }

    @RequestMapping("/CarLongAppoint")
    @ApiOperation("长期物流司机预约")
    public Result carLongAppoint(@RequestBody @Valid CarLongAppointment carLongAppointment){
        return carLongAppointmentService.carLongAppoint(carLongAppointment);

    }

    @RequestMapping("/CarShortAppoint")
    @ApiOperation("临时物流司机预约")
    public Result carShortAppoint(@RequestBody @Valid CarShortAppointment carShortAppointment){
        return carShortAppointmentService.carShortAppoint(carShortAppointment);

    }

    @RequestMapping("/BuildAppoint")
    @ApiOperation("施工人员预约")
    public Result buildAppoint(@RequestBody @Valid BuildAppointment buildAppointment){
        return buildService.buildAppoint(buildAppointment);

    }
}