package visite_system.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("vip_examine")
@ApiModel(value = "Vip审批实体类")
public class VipExamine {
    @TableId
    @ApiModelProperty("id  ")
    private Integer id; // id
    @ApiModelProperty("预约id ")
    private Integer appointmentId; // 预约id
    @ApiModelProperty("申请部门意见 0-同意 1-不同意 ")
    private Integer visiteDeptOpinion; // 申请部门意见 0-同意 1-不同意
    @ApiModelProperty("人事部门意见 0-同意 1-不同意")
    private Integer renshiOpinion; // 人事部门意见 0-同意 1-不同意
    @ApiModelProperty("总经理意见 0-同意 1-不同意")
    private Integer manageOpinion; // 总经理意见 0-同意 1-不同意
    @ApiModelProperty("总经理id")
    private Long manageId; // 总经理id
    @ApiModelProperty("人事id")
    private Long renshiId; // 人事id
    @ApiModelProperty("申请部门id ")
    private Long visiteDeptId; // 申请部门id
    @ApiModelProperty("二维码")
    private String code; // 二维码
    @ApiModelProperty("是否离开 0-离开 1-未离开")
    private Integer isgo; // 是否离开 0-离开 1-未离开  
}