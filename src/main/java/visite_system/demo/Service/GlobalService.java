package visite_system.demo.Service;

import visite_system.demo.Pojo.Result;

public interface GlobalService {
    Result queryMyAppointment();

    Result queryCodeById(Long id);

    Result queryMyExamine();
}
