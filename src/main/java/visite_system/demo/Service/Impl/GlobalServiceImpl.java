package visite_system.demo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visite_system.demo.Entity.*;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.*;
import visite_system.demo.Pojo.CarLongExamineInfo;
import visite_system.demo.Pojo.CarShortExamineInfo;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Pojo.VipExamineInfo;
import visite_system.demo.Service.GlobalService;

import java.util.*;

@Service
public class GlobalServiceImpl implements GlobalService {
    @Autowired
    private Build_AppointmentMapper buildAppointmentMapper;

    @Autowired
    private CarLong_AppointmentMapper  carLongAppointmentMapper;

    @Autowired
    private CarLong_RecordMapper  carLongRecordMapper;

    @Autowired
    private CarShort_AppointmentMapper carShortAppointmentMapper;

    @Autowired
    private CarShort_RecordMapper  carShortRecordMapper;

    @Autowired
    private Common_AppointmentMapper commonAppointmentMapper;

    @Autowired
    private VIP_AppointmentMapper vipAppointmentMapper;

    @Autowired
    private VIP_ExamineMapper vipExamineMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

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

    @Override
    public Result queryMyExamine() throws Exception {
        User user = ThreadLocalUtil.get();
        Long id = user.getId();
        //是否是内部人员
        if(user.getIsEmployee()==1){
            throw new Exception("不是内部人员,没有权限");
        }

        //普通访客
        LambdaQueryWrapper<CommonAppointment> commonAppointmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        commonAppointmentLambdaQueryWrapper.eq(CommonAppointment::getVisiteEmployeeId,id);
        List<CommonAppointment> commonAppointments = commonAppointmentMapper.selectList(commonAppointmentLambdaQueryWrapper);
        //查询登录者是否是部门部长
        List<CarLongExamineInfo> carLongExamineInfos=new ArrayList<>();
        List<CarShortExamineInfo> carShortExamineInfos=new ArrayList<>();
        Dept dept = deptMapper.selectById(user.getDeptId());
        Set vipExamineInfos=new HashSet();
        if(dept.getManagerId()==id){
            List<VipExamineInfo> vipExamineInfo=new ArrayList<>();
            //是部长
            //vip访客
            if(dept.getDeptId()==3){
                //是人事部部长
                 vipExamineInfo= vipAppointmentMapper.queryAllExamin();
            }
            if(dept.getDeptId()==1){
                //是董事部部长
                vipExamineInfo= vipAppointmentMapper.queryAllExamin();
            }
            //是其他部门部长，查询是否有需要我审批的
            List<VipExamineInfo> vipExamine = vipAppointmentMapper.queryMyExamineByDeptId(dept.getDeptId());

            //合并
            vipExamineInfos.addAll(vipExamineInfo);
            vipExamineInfos.addAll(vipExamine);

            //是物流部部长(审批物流)
            if(dept.getDeptId()==6){
                carLongExamineInfos= carLongAppointmentMapper.queryMyExamine();
                carShortExamineInfos= carShortAppointmentMapper.queryMyExamine();
            }
        }
        //是保安
        if(user.getDeptId()==5){
            carLongExamineInfos= carLongAppointmentMapper.queryMyExamine();
            carShortExamineInfos= carShortAppointmentMapper.queryMyExamine();
        }

        //建筑工人
        LambdaQueryWrapper<BuildAppointment> buildAppointmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        buildAppointmentLambdaQueryWrapper
                .eq(BuildAppointment::getVisiteEmployeeId,id);
        List<BuildAppointment> buildAppointments = buildAppointmentMapper.selectList(buildAppointmentLambdaQueryWrapper);
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0,commonAppointments);
        hashMap.put(1,vipExamineInfos);
        hashMap.put(2,carLongExamineInfos);
        hashMap.put(3,carShortExamineInfos);
        hashMap.put(4,buildAppointments);
        return Result.ok(hashMap);
    }

}
