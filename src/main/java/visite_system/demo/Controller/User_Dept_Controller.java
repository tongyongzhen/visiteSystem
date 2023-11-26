package visite_system.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.DeptService;
import visite_system.demo.Service.UserService;

@RestController
@RequestMapping("/user_Dept")
@Api("用户部门相关api")
public class User_Dept_Controller {

    @Autowired
    private DeptService deptService;

    @Autowired
    private UserService userService;


    @GetMapping("/queryAllDept")
    @ApiOperation("查询所有部门")
    public Result queryAllDept(){
        return deptService.queryAllDept();
    }

    @GetMapping("/queryAllUsersByDeptId/{id}")
    @ApiOperation("根据部门id查询所有部门人员")
    public Result queryAllUsersByDeptId(
            @PathVariable("id") @ApiParam("传入的是部门id") Long id){
        return userService.queryAllDept(id);
    }

    @GetMapping("/ofMe")
    @ApiOperation("查询所登录用户的信息")
    public Result ofMe(){
        return userService.ofMe();
    }
}
