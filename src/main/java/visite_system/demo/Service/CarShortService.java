package visite_system.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import visite_system.demo.Entity.CarShortAppointment;
import visite_system.demo.Entity.CarShortRecord;
import visite_system.demo.Pojo.CarPicture;
import visite_system.demo.Pojo.Result;

public interface CarShortService{
    Result carShortAppoint(CarShortAppointment carShortAppointment) throws Exception;

    Result carShortPictureUp(CarPicture carPicture);

    Result carShortPictureExamine(CarShortRecord carShortRecord);

    Result carShortBaoAnExamine(CarShortRecord carShortRecord);

    Result queryShortPictureById(Long id);
}
