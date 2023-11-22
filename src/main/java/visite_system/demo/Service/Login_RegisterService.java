package visite_system.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import visite_system.demo.Entity.User;
import visite_system.demo.Pojo.LoginDetail;
import visite_system.demo.Pojo.Result;

public interface Login_RegisterService extends IService<User> {
    Result login(LoginDetail loginDetail) throws Exception;

    Result register(User user) throws Exception;
}
