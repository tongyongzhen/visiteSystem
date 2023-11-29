package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private GlobalService globalService;


    @PostMapping("/CommonAppoint")
    @ApiOperation("普通访客预约")
    public Result commonAppoint(@RequestBody @Valid CommonAppointment commonAppointment){
        return commonAppointmentService.commonAppoint(commonAppointment);

    }

    @PostMapping("/VIPAppoint")
    @ApiOperation("VIP访客预约")
    public Result vipAppoint(@RequestBody @Valid VipAppointment vipAppointment) throws Exception {
        return vipAppointmentService.vipAppoint(vipAppointment);

    }

    @PostMapping("/CarLongAppoint")
    @ApiOperation("长期物流司机预约")
    public Result carLongAppoint() throws Exception {
        return carLongAppointmentService.carLongAppoint();

    }

    @PostMapping("/CarShortAppoint")
    @ApiOperation("临时物流司机预约")
    public Result carShortAppoint(@RequestBody @Valid CarShortAppointment carShortAppointment) throws Exception {
        return carShortAppointmentService.carShortAppoint(carShortAppointment);

    }

    @PostMapping("/BuildAppoint")
    @ApiOperation("施工人员预约")
    public Result buildAppoint(@RequestBody @Valid BuildAppointment buildAppointment){
        return buildService.buildAppoint(buildAppointment);
    }

    @GetMapping("/queryMyAppointment")
    @ApiOperation("查询我的预约")
    public Result queryMyAppointment(){
        return globalService.queryMyAppointment();
    }

    @GetMapping("/queryCodeById/{id}")
    @ApiOperation("根据id查询二维码")
    public Result queryCodeById(@PathVariable("id") Long id){
        return globalService.queryCodeById(id);
    }

    @GetMapping("/queryVisitMe")
    @ApiOperation("查询访问我的")
    public Result queryVisitMe() throws Exception {
        return globalService.queryVisitMe();
    }
}
