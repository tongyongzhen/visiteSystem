package visite_system.demo.Entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@ApiModel(value = "用户表")
public class User {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("姓名")
    @NotBlank
    private String name;
    @NotBlank
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("车牌号")
    @NotBlank
    private String carnum;
    @ApiModelProperty("0-普通访客，1-VIP，行政访客，2-物流司机，长期，3-物流司机，临时，4-施工人员")
    private Integer type;
    @ApiModelProperty("所属公司")
    @NotBlank
    private String company;
    @ApiModelProperty("密码")
    @NotBlank
    private String password;
    @ApiModelProperty(value = "是否是内部人员 0-是，1-不是")
    private int isEmployee;
    @ApiModelProperty("内部人员所属部门id")
    private Long deptId;
}