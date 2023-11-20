package visite_system.demo.Service;

import visite_system.demo.Entity.User;
import visite_system.demo.Pojo.LoginDetail;
import visite_system.demo.Pojo.Result;

public interface Login_RegisterService {
    Result login(LoginDetail loginDetail) throws Exception;

    Result register(User user) throws Exception;
}
