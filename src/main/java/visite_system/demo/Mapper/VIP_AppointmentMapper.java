package visite_system.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import visite_system.demo.Entity.VipAppointment;
import visite_system.demo.Entity.VipExamine;

import java.util.List;

public interface VIP_AppointmentMapper extends BaseMapper<VipAppointment> {
     List<VipExamine> queryVipAppointmentByUserId(@Param("id") Long id);
}
