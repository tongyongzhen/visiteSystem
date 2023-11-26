package visite_system.demo.Service;

import visite_system.demo.Pojo.Result;

public interface UserService {
    Result queryAllDept(Long id);

    Result ofMe();

}
