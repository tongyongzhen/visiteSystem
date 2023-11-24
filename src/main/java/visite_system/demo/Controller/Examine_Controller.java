package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import visite_system.demo.Entity.CommonAppointment;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Examine")
@Api("审批相关api")
public class Examine_Controller {
    @Autowired
    private CommonService commonService;

    @Autowired
    private VIPService vipService;

    @Autowired
    private CarLongService carLongService;

    @Autowired
    private CarShortService carShortService;

    @Autowired
    private BuildService buildService;

    @RequestMapping("/CommonExamine")
    @ApiOperation("普通访客审批")
    public Result commonExamine(@RequestBody CommonAppointment commonAppointment){
        return commonService.commonExamine(commonAppointment);

    }


}
