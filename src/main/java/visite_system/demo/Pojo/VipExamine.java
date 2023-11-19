package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vip_examine")
public class VipExamine {
    @TableId
    private Integer id; // id  
    private Integer appointmentId; // 预约id  
    private Integer visiteDeptOpinion; // 申请部门意见 0-同意 1-不同意  
    private Integer reshiOpinion; // 人事部门意见 0-同意 1-不同意  
    private Integer manageOpinion; // 总经理意见 0-同意 1-不同意  
    private Long manageId; // 总经理id  
    private Long reshiId; // 人事id  
    private Long visiteDeptId; // 申请部门id  
    private String code; // 二维码  
    private Integer isgo; // 是否离开 0-离开 1-未离开  
}