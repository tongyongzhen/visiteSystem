package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.*;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.*;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Pojo.VipExamineInfo;
import visite_system.demo.Service.GlobalService;

import java.util.List;
import java.util.Map;

@Service
public class GlobalServiceImpl implements GlobalService {
    @Autowired
    private Build_AppointmentMapper buildAppointmentMapper;

    @Autowired
    private CarLong_AppointmentMapper  carLongAppointmentMapper;

    @Autowired
    private CarShort_AppointmentMapper carShortAppointmentMapper;

    @Autowired
    private Common_AppointmentMapper commonAppointmentMapper;

    @Autowired
    private VIP_AppointmentMapper vipAppointmentMapper;

    @Autowired
    private VIP_ExamineMapper vipExamineMapper;

    @Override
    public Result queryMyAppointment() {
        User user = ThreadLocalUtil.get();
        Long userId = user.getId();
        Integer type = user.getType();
        //内部人员
        if(user.getIsEmployee()==0){
            List<VipExamineInfo> vipExamineInfos = vipAppointmentMapper.queryVipAppointmentByUserId(userId);
            return Result.ok(vipExamineInfos);
        }
        //不是内部人员
        //普通访客
        if(type==0){
            LambdaQueryWrapper<CommonAppointment> commonAppointmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            commonAppointmentLambdaQueryWrapper.eq(CommonAppointment::getUserId,userId);
            List<CommonAppointment> commonAppointments = commonAppointmentMapper.selectList(commonAppointmentLambdaQueryWrapper);
            return Result.ok(commonAppointments);
        }
        //临时物流司机
        if(type==3){
            LambdaQueryWrapper<CarShortAppointment> carShortAppointmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            carShortAppointmentLambdaQueryWrapper.eq(CarShortAppointment::getUserId,userId);
            List<CarShortAppointment> carShortAppointments = carShortAppointmentMapper.selectList(carShortAppointmentLambdaQueryWrapper);
            return Result.ok(carShortAppointments);
        }

        //长期物流司机
        if(type==2){
            LambdaQueryWrapper<CarLongAppointment> carLongAppointmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            carLongAppointmentLambdaQueryWrapper.eq(CarLongAppointment::getUserId,userId);
            List<CarLongAppointment> carLongAppointments = carLongAppointmentMapper.selectList(carLongAppointmentLambdaQueryWrapper);
            return Result.ok(carLongAppointments);
        }
        //建筑工人
        if(type==4){
            LambdaQueryWrapper<BuildAppointment> buildAppointmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            buildAppointmentLambdaQueryWrapper.eq(BuildAppointment::getUserId,userId);
            List<BuildAppointment> buildAppointments = buildAppointmentMapper.selectList(buildAppointmentLambdaQueryWrapper);
            return Result.ok(buildAppointments);
        }
        return Result.fail(500,"账号异常");
    }

    @Override
    public Result queryCodeById(Long id) {
        User user = ThreadLocalUtil.get();
        Long userId = user.getId();
        Integer type = user.getType();
        //内部人员
        if(user.getIsEmployee()==0){
            VipExamine vipExamine = vipExamineMapper.selectById(id);
            return Result.ok(vipExamine.getCode());
        }
        //不是内部人员
        //普通访客
        if(type==0){
            CommonAppointment commonAppointment = commonAppointmentMapper.selectById(id);
            return Result.ok(commonAppointment.getCode());
        }
        //临时物流司机
        if(type==3){
            CarShortAppointment carShortAppointment = carShortAppointmentMapper.selectById(id);
            return Result.ok(carShortAppointment.getCode());
        }

        //长期物流司机
        if(type==2){
            CarLongAppointment carLongAppointment = carLongAppointmentMapper.selectById(id);
            return Result.ok(carLongAppointment.getCode());
        }
        //建筑工人
        if(type==4){
            BuildAppointment buildAppointment = buildAppointmentMapper.selectById(id);
            return Result.ok(buildAppointment.getCode());
        }
        return Result.fail(500,"账号异常");
    }
}
