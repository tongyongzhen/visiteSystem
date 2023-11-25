package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import visite_system.demo.Entity.User;
import visite_system.demo.Pojo.LoginDetail;
import visite_system.demo.Pojo.LoginValid;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.Login_RegisterService;


@RestController
@RequestMapping("/login_register")
@Api(value = "登录注册相关api")
public class Login_Register_Controller {

    @Autowired
    private Login_RegisterService loginRegisterService;
    /**
     * 登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录,参数中要有手机号，密码")
    public Result login(@RequestBody @Validated(LoginValid.class) LoginDetail loginDetail) throws Exception {
        return loginRegisterService.login(loginDetail);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result register(@RequestBody @Validated(value = {LoginValid.class}) User user) throws Exception {
        return loginRegisterService.register(user);
    }

}
