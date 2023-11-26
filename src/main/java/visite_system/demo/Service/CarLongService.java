package visite_system.demo.Service;

import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Entity.CarLongRecord;
import visite_system.demo.Pojo.Result;

public interface CarLongService {
    Result carLongAppoint() throws Exception;

    Result carLongPictureUp(Long id,MultipartFile multipartFile);

    Result carLongPictureExamine(CarLongRecord carLongRecord);

    Result carLongBaoAnExamine(CarLongRecord carLongRecord);
}
