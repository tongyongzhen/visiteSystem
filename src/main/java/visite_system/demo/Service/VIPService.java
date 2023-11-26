package visite_system.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import visite_system.demo.Entity.VipAppointment;
import visite_system.demo.Entity.VipExamine;
import visite_system.demo.Pojo.Result;

public interface VIPService{
    Result vipAppoint(VipAppointment vipAppointment) throws Exception;

    Result vipExamine(VipExamine vipExamine);

    Result vipVisiteEnd(Long id);
}
