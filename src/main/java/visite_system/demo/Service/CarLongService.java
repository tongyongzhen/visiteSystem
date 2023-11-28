package visite_system.demo.Service;

import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Entity.CarLongRecord;
import visite_system.demo.Pojo.Result;

import javax.servlet.http.HttpServletRequest;

public interface CarLongService {
    Result carLongAppoint() throws Exception;

    Result carLongPictureUp(HttpServletRequest request);

    Result carLongPictureExamine(CarLongRecord carLongRecord);

    Result carLongBaoAnExamine(CarLongRecord carLongRecord);
}
