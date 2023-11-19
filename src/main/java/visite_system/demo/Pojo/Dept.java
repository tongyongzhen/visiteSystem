package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// dept实体类
@Data
@TableName("dept")
public class Dept {
    @TableId(type = IdType.AUTO)
    private Long dept_id;
    private String dept_name;
    private Long manager_id;
}  