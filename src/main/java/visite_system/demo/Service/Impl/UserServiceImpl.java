package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.UserMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result queryAllDept(Long id) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getDeptId,id);
        List<User> users = userMapper.selectList(wrapper);
        return Result.ok(users);
    }

    @Override
    public Result ofMe() {
        User user = ThreadLocalUtil.get();
        user.setPassword(null);
        return Result.ok(user);
    }

    @Override
    public Result queryDeptById(Long id) {
        User user = userMapper.selectById(id);
        return Result.ok(user);
    }
}
