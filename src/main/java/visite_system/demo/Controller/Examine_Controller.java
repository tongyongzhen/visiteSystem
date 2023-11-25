package visite_system.demo.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.*;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/Examine")
@Api("审批相关api")
@Validated
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
    public Result commonExamine(@RequestBody @ApiParam(value = "至少传入id和isagree",required = true)
                                        CommonAppointment commonAppointment) throws Exception {
        return commonService.commonExamine(commonAppointment);

    }

    @RequestMapping("/VipExamine")
    @ApiOperation("VIP访客审批")
    public Result vipExamine(@RequestBody @Valid @ApiParam(value = "所有数据都要传，意见与审批人id要一一对应",required = true)
                                     VipExamine vipExamine) throws Exception {
        return vipService.vipExamine(vipExamine);

    }

    @RequestMapping("/BuildExamine")
    @ApiOperation("施工人员审批")
    public Result buildExamine(@RequestBody @ApiParam(value = "必须要有examinerId和isagree",required = true)
                                       BuildAppointment buildAppointment) throws Exception {
        return buildService.buildExamine(buildAppointment);

    }

    @RequestMapping("/CarLongPictureUp")
    @ApiOperation("长期物流司机货物照片上传")
    public Result carLongPictureUp(@ApiParam(value = "传的是审批id不是登记id",required = true)
                                       @NotNull(message = "id不能为空")
                                               Long id, MultipartFile multipartFile)throws Exception {
        return carLongService.carLongPictureUp(id,multipartFile);

    }


}
