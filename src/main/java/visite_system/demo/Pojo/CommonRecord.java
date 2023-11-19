package visite_system.demo.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// common_record实体类
@Data
@TableName("common_record")
public class CommonRecord {
    @TableId(type = IdType.AUTO)
    private int id;
}  