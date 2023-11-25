package visite_system.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("build_appointment")
@ApiModel("建筑工人登记")
public class BuildAppointment {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("访问部门id")
    @NotNull
    private Long visiteDeptId;
    @ApiModelProperty("被访问人id")
    private Long visiteEmployeeId;
    @ApiModelProperty("审核是否同意")
    private Integer isagree;
    @ApiModelProperty("审核人员id")
    private Long examinerId;
    @ApiModelProperty("是否拜访")
    private Integer isvisit;
    @ApiModelProperty("是否离开")
    private Integer isgo;
    @ApiModelProperty("二维码")
    private String code;
}