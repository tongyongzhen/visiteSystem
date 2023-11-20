package visite_system.demo.Service.Impl;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import visite_system.demo.Constant.RedisKey;
import visite_system.demo.Entity.User;
import visite_system.demo.Mapper.Login_RegisterMapper;
import visite_system.demo.Pojo.LoginDetail;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.Login_RegisterService;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class Login_RegisterServiceImpl implements Login_RegisterService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Login_RegisterMapper loginRegisterMapper;
    @Override
    public Result login(LoginDetail loginDetail) throws Exception {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>();
        userLambdaQueryWrapper.eq(User::getPhone, loginDetail.getPhone());
        User user = loginRegisterMapper.selectOne(userLambdaQueryWrapper);
        if(ObjectUtils.isEmpty(user)
                || !user.getPassword().equals(loginDetail.getPassword())){
            throw new Exception("用户名或密码错误");
        }
        //生成token
        String token = UUID.randomUUID().toString();
        //用户信息存入redis
        String KEY=RedisKey.LOGIN_KEY+token;
        String value=JSONUtil.toJsonStr(user);
        stringRedisTemplate.opsForValue().set(KEY,value,30, TimeUnit.MINUTES);
        return Result.ok(token);
    }

    @Override
    public Result register(User user) throws Exception {
        String phone=user.getPhone();
        //检验手机号是否正确
        String regx="/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$/";
        if(!phone.matches(regx)){
            throw new Exception("手机号格式不正确");
        }
        //查询是否注册过
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getPhone,phone);
        User u = loginRegisterMapper.selectOne(userLambdaQueryWrapper);
        if(!ObjectUtils.isEmpty(u)){
            throw new Exception("用户已存在");
        }
        //注册
        loginRegisterMapper.insert(user);
        return Result.ok();
    }
}
