package visite_system.demo.GlobalUtils;

import org.springframework.stereotype.Component;
import visite_system.demo.Entity.User;


public class ThreadLocalUtil {
    private static final ThreadLocal<User> threadLocal=new ThreadLocal();


    public static void set(User o){
        threadLocal.set(o);
    }

    public static User get(){
        return threadLocal.get();
    }


    public static void remove(){
        threadLocal.remove();
    }
}
