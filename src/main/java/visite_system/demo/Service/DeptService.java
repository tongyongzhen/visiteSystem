package visite_system.demo.Service;

import visite_system.demo.Pojo.Result;

public interface DeptService {
    Result queryAllDept();

    Result queryDeptById(Long id);
}
