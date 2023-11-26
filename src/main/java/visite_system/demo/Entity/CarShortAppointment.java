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
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("car_short_appointment")
@ApiModel("临时物流司机预约")
public class CarShortAppointment {
    @TableId
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("计划进出次数")
    @NotNull
    private Integer goOutCount;
    @ApiModelProperty("二维码")
    private String code;
    @ApiModelProperty("预约时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appointTime;
}