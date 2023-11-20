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

import java.util.Date;

// common_appointment实体类
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("common_appointment")
@ApiModel("普通访客预约")
public class CommonAppointment {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("用户id")
    private Integer user_id;
    @ApiModelProperty("访问部门id")
    private Integer visite_dept_id;
    @ApiModelProperty("被访问人id")
    private Integer visite_employee_id;
    @ApiModelProperty("访问开始时间")
    private Date visite_start_time;
    @ApiModelProperty("访问结束时间")
    private Date visite_end_time;
    @ApiModelProperty("审核是否同意")
    private Integer isagree;
    @ApiModelProperty("是否拜访")
    private Integer isvisite;
    @ApiModelProperty("访问是否结束")
    private Integer isgo;
    @ApiModelProperty("二维码")
    private String code;
}  