package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("car_long_record")
public class CarLongRecord {
    @TableId
    private Long id;
    private Long appointmentId;
    private java.util.Date enterTime;
    private java.util.Date goTime;
    private Long examineId;
    private Integer examineResult;
    private Long baoanId;
    private Integer baoanResult;
    private String picture;
}