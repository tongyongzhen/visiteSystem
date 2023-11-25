package visite_system.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Pojo.Result;

public interface CarLongService {
    Result carLongAppoint(CarLongAppointment carLongAppointment);

    Result carLongPictureUp(Long id,MultipartFile multipartFile);
}
