package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("car_long_appointment")
public class CarLongAppointment {
    @TableId
    private Integer id;
    private Long userId;
    private String code;
}