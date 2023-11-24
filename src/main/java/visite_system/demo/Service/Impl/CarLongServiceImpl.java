package visite_system.demo.Service.Impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.CarLongAppointment;
import visite_system.demo.Entity.User;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.CarLong_AppointmentMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.CarLongService;

@Service
public class CarLongServiceImpl implements CarLongService {

    @Autowired
    private CarLong_AppointmentMapper carLongAppointmentMapper;

    @Autowired
    private QrCodeUtils qrCodeUtils;

    @Override
    public Result carLongAppoint(CarLongAppointment carLongAppointment) {
        User user = ThreadLocalUtil.get();
        carLongAppointment.setUserId(user.getId());
        carLongAppointmentMapper.insert(carLongAppointment);
        //获取id
        LambdaQueryWrapper<CarLongAppointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CarLongAppointment::getUserId,user.getId());
        CarLongAppointment one = carLongAppointmentMapper.selectOne(wrapper);
        //生成二维码
        String qrCode = qrCodeUtils.createQrCode(String.valueOf(one.getId()));
        one.setCode(qrCode);
        carLongAppointmentMapper.insert(one);
        return Result.ok(one);
    }
}
