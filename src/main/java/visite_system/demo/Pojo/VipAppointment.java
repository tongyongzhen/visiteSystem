package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vip_appointment")
public class VipAppointment {
    @TableId
    private Long id; // 预约id  
    private String carnum; // 车牌号  
    private Long visiteEmployeeId; // 被访问人id  
}