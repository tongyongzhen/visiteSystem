package visite_system.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Pojo.CarLongExamineInfo;

import java.util.List;

public interface CarLong_AppointmentMapper extends BaseMapper<CarLongAppointment> {

    List<CarLongExamineInfo> queryMyExamine();
}
