package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import visite_system.demo.Entity.User;
import visite_system.demo.Pojo.LoginDetail;
import visite_system.demo.Pojo.Result;

import java.sql.ResultSet;

@RestController
@RequestMapping("/login_register")
@Api(value = "登录注册相关api")
public class Login_Register_Controller {
    /**
     * 登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录,参数中要有手机号，密码")
    public Result login(@RequestBody LoginDetail loginDetail){
        return null;
    }

}
