package visite_system.demo.Pojo;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Object data;


    public static Result ok(){
        Result result = new Result();
        result.setCode(200);
        return result;
    }
    public static Result ok(Object data){
        Result result = Result.ok();
        result.setData(data);
        return result;
    }
    public static Result fail(int code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
