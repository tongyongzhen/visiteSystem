package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("build_appointment")
public class BuildAppointment {
    private Long id;
    private Long userId;
    private Long visiteDeptId;
    private Integer isAgree;
    private Integer isVisit;
    private Integer isGo;
    private String code;
}