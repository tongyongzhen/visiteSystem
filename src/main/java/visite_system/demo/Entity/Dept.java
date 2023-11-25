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

// dept实体类
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dept")
@ApiModel(value = "部门信息")
public class Dept {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("部门id")
    private Long deptId;
    @ApiModelProperty("部门名称")
    private String deptName;
    @ApiModelProperty("部门经理id")
    private Long managerId;
}  