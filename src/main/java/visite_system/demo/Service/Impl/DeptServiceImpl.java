package visite_system.demo.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.Dept;
import visite_system.demo.Mapper.DeptMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.DeptService;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Result queryAllDept() {
        List<Dept> depts = deptMapper.selectList(null);
        return Result.ok(depts);
    }

    @Override
    public Result queryDeptById(Long id) {
        Dept dept = deptMapper.selectById(id);
        return Result.ok(dept);
    }
}
