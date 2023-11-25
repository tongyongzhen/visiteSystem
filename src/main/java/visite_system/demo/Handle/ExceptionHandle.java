package visite_system.demo.Handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import visite_system.demo.Pojo.Result;

import javax.servlet.ServletException;

/**
 * 全局异常处理器
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    @ExceptionHandler(value = {Exception.class})
    public Result exception(Exception exception){
        System.out.println("进入exception处理器");
        return Result.fail(500,exception.getMessage());
    }

    @ExceptionHandler(value = {ServletException.class})
    public Result servletException(Exception exception){
        System.out.println("进入servletException处理器");
        return Result.fail(401,exception.getMessage());
    }
}
