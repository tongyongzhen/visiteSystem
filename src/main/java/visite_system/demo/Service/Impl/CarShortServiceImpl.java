package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.CarShortAppointment;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.CarShort_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CarShortService;

@Service
public class CarShortServiceImpl implements CarShortService {

    @Autowired
    private CarShort_AppointmentMapper carShortAppointmentMapper;

    @Autowired
    private QrCodeUtils qrCodeUtils;
    @Override
    public Result carShortAppoint(CarShortAppointment carShortAppointment) {
        User user = ThreadLocalUtil.get();
        carShortAppointment.setUserId(user.getId());
        carShortAppointmentMapper.insert(carShortAppointment);
        LambdaQueryWrapper<CarShortAppointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CarShortAppointment::getUserId,user.getId());
        CarShortAppointment one = carShortAppointmentMapper.selectOne(wrapper);
        //生成二维码
        String qrCode = qrCodeUtils.createQrCode(String.valueOf(one.getId()));
        one.setCode(qrCode);
        carShortAppointmentMapper.insert(one);
        return Result.ok(one);
    }

}
