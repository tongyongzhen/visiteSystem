package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/visiteEnd")
@Api("访问结束api")
@Validated
public class visiteEnd_Controller {
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

    @GetMapping(value = "/commonVisiteEnd/{id}")
    @ApiOperation("普通访客访问结束")
    public Result commonVisiteEnd(@NotNull(message = "id不能为空")
                                      @PathVariable("id") Long id) throws Exception {
        return commonService.commonVisiteEnd(id);
    }

    @GetMapping(value = "/vipVisiteEnd/{id}")
    @ApiOperation("vip访客访问结束")
    public Result vipVisiteEnd(@NotNull(message = "id不能为空")
                                @ApiParam(value = "传的是vip预约id",required = true)
                                  @PathVariable("id") Long id) throws Exception {
        return vipService.vipVisiteEnd(id);
    }
}
