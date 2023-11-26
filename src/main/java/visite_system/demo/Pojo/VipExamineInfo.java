package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class VipExamineInfo {
    @ApiModelProperty("id")
    private Long id; // id
    @ApiModelProperty("预约id")
    private Long appointmentId; // 预约id
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
    @ApiModelProperty("申请部门审批者id ")
    private Long visiteDeptId; // 申请部门id
    @ApiModelProperty("二维码")
    private String code; // 二维码
    @ApiModelProperty("是否离开 0-离开 1-未离开")
    private Integer isgo; // 是否离开 0-离开 1-未离开
    private String carnum;
    private String company;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appointTime;
}
