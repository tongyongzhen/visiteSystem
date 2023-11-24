package visite_system.demo.GlobalUtils;


import visite_system.demo.Entity.User;

public class LoginUtils {
    /**
     * 获取登录用户
     * @return
     */
    public static User getLoginUser(){
        return ThreadLocalUtil.get();
    }

}
