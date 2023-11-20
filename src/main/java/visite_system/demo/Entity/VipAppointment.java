package visite_system.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("vip_appointment")
@ApiModel(value = "vip预约")
public class VipAppointment {
    @TableId
    @ApiModelProperty("预约id  ")
    private Long id; // 预约id
    @ApiModelProperty("车牌号 ")
    private String carnum; // 车牌号
    @ApiModelProperty("被访问人id ")
    private Long visiteEmployeeId; // 被访问人id  
}