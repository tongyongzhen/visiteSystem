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

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("car_long_record")
@ApiModel("长期物流司机进出记录")
public class CarLongRecord {
    @TableId
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("预约id")
    private Long appointmentId;
    @ApiModelProperty("进入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date enterTime;
    @ApiModelProperty("离开时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date goTime;
    @ApiModelProperty("审核人id")
    private Long examineId;
    @ApiModelProperty("审核结果")
    private Integer examineResult;
    @ApiModelProperty("审核保安id")
    private Long baoanId;
    @ApiModelProperty("保安审核结果")
    private Integer baoanResult;
    @ApiModelProperty("货物照片")
    private String picture;
    @ApiModelProperty("拍摄人员id")
    private Long cameramanId;
}