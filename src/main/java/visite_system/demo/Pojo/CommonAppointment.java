package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

// common_appointment实体类
@Data
@TableName("common_appointment")
public class CommonAppointment {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer user_id;
    private Integer visite_dept_id;
    private Integer visite_employee_id;
    private Date visite_start_time;
    private Date visite_end_time;
    private Integer isagree;
    private Integer isvisite;
    private Integer isgo;
    private String code;
}  