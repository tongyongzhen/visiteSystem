package visite_system.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import visite_system.demo.Entity.CarShortAppointment;
import visite_system.demo.Pojo.CarLongExamineInfo;
import visite_system.demo.Pojo.CarShortExamineInfo;

import java.util.List;

public interface CarShort_AppointmentMapper extends BaseMapper<CarShortAppointment> {

    List<CarShortExamineInfo> queryMyExamine();
}
