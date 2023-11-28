package visite_system.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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
    @NotBlank
    private String carnum; // 车牌号
    @ApiModelProperty("被访问人id ")
    private Long visiteEmployeeId; // 被访问人id
     @ApiModelProperty("来访单位 ")
     @NotBlank
    private String company;
    @ApiModelProperty("访问部门id")
    private Long visiteDeptId;
    @ApiModelProperty("预约时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appointTime;
}