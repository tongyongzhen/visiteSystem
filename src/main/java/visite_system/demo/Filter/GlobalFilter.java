package visite_system.demo.Filter;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import visite_system.demo.Constant.RedisKey;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;

@Component
public class GlobalFilter implements Filter {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!(servletRequest instanceof HttpServletRequest)||!(servletResponse instanceof HttpServletResponse)){
            throw new ServletException("只支持http请求");
        }
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取请求参数
        String requestURI = request.getRequestURI();
        //路径匹配
        System.out.println("requestURI:"+requestURI);
        if(requestURI.matches(".*(register|login|swagger|/|api-docs|csrf).*")){
            //放行
            System.out.println("放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //获取请求头
        String token =request.getHeader("token");
        System.out.println("token:"+token);
        //查询redis
        String userDetail = stringRedisTemplate.opsForValue().get(RedisKey.LOGIN_KEY + token);
        if(!StringUtils.hasText(userDetail)){
            throw new ServletException("超时登录");
        }
        //存入threadLocal
        User user = JSONUtil.toBean(userDetail, User.class);
        ThreadLocalUtil.set(user);
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        //移除
        ThreadLocalUtil.remove();
    }
}
