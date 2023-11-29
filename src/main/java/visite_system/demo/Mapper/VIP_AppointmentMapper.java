package visite_system.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import visite_system.demo.Entity.VipAppointment;
import visite_system.demo.Pojo.VipExamineInfo;

import java.util.List;
import java.util.Map;

public interface VIP_AppointmentMapper extends BaseMapper<VipAppointment> {
     List<VipExamineInfo> queryVipAppointmentByUserId(@Param("id") Long id);

     List<VipExamineInfo> queryMyExamineByDeptId(@Param("deptId") Long deptId);

     List<VipExamineInfo> queryAllExamin();

     List<VipExamineInfo> queryVisitMe(Long id);
}
