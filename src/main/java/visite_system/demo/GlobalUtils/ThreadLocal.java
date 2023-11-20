package visite_system.demo.GlobalUtils;

import org.springframework.stereotype.Component;

@Component
public class ThreadLocal {
    private static final ThreadLocal threadLocal=new ThreadLocal();

    public static void set(Object o){
        threadLocal.set(o);
    }

    public static Object get(){
        return threadLocal.get();
    }


    public static void remove(){
        threadLocal.remove();
    }
}
