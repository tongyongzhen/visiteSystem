package visite_system.demo.Entity;

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
@TableName("build_appointment")
@ApiModel("建筑工人登记")
public class BuildAppointment {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("访问部门id")
    private Long visiteDeptId;
    @ApiModelProperty("审核是否同意")
    private Integer isAgree;
    @ApiModelProperty("是否拜访")
    private Integer isVisit;
    @ApiModelProperty("是否离开")
    private Integer isGo;
    @ApiModelProperty("二维码")
    private String code;
}