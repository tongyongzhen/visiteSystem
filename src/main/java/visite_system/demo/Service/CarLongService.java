package visite_system.demo.Service;

import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Entity.CarLongRecord;
import visite_system.demo.Pojo.CarPicture;
import visite_system.demo.Pojo.Result;

import javax.servlet.http.HttpServletRequest;

public interface CarLongService {
    Result carLongAppoint() throws Exception;

    Result carLongPictureUp(CarPicture carPicture);

    Result carLongPictureExamine(CarLongRecord carLongRecord);

    Result carLongBaoAnExamine(CarLongRecord carLongRecord);

    Result queryLongPictureById(Long id);
}
