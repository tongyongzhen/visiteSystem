package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("car_short_appointment")
public class CarShortAppointment {
    @TableId
    private Integer id;
    private Long userId;
    private Integer goOutCount;
    private String code;
}