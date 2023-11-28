package visite_system.demo.Service.Impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import visite_system.demo.Entity.Dept;
import visite_system.demo.Entity.User;
import visite_system.demo.Entity.VipAppointment;
import visite_system.demo.Entity.VipExamine;
import visite_system.demo.GlobalUtils.QrCodeUtils;
import visite_system.demo.GlobalUtils.ThreadLocalUtil;
import visite_system.demo.Mapper.DeptMapper;
import visite_system.demo.Mapper.VIP_AppointmentMapper;
import visite_system.demo.Mapper.VIP_ExamineMapper;
import visite_system.demo.Pojo.Result;
import visite_system.demo.Service.VIPService;

import java.util.Date;


@Service
public class VIPServiceImpl implements VIPService {

    @Autowired
    private VIP_AppointmentMapper vipAppointmentMapper;

    @Autowired
    private VIP_ExamineMapper vipExamineMapper;

    @Autowired
    private QrCodeUtils qrCodeUtils;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Result vipAppoint(VipAppointment vipAppointment) throws Exception {
        LambdaQueryWrapper<VipAppointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(VipAppointment::getCarnum,vipAppointment.getCarnum());
        VipAppointment one = vipAppointmentMapper.selectOne(wrapper);
        if(!ObjectUtils.isEmpty(one)){
            throw new Exception("当前车牌已经预约过");
        }
        //获取登录人员信息
        User user = ThreadLocalUtil.get();
        vipAppointment.setVisiteEmployeeId(user.getId());
        vipAppointment.setVisiteDeptId(user.getDeptId());
        vipAppointment.setAppointTime(new Date());
        //存入数据库
        vipAppointmentMapper.insert(vipAppointment);
        //获取id
        one = vipAppointmentMapper.selectOne(wrapper);
        Long appointmentId = one.getId();
        VipExamine vipExamine=null;
        //查询身份信息
        Dept dept = deptMapper.selectById(user.getDeptId());
        //是部长
        if(dept.getManagerId()==user.getId()){
            vipExamine = vipExamine.builder()
                    .appointmentId(appointmentId)
                    .deptExamineId(user.getId())
                    .visiteDeptOpinion(0)
                    .build();

            //是人事部部长
            if(dept.getDeptId()==3){
                vipExamine.setRenshiId(user.getId());
                vipExamine.setRenshiOpinion(0);
            }
            //是董事部部长
            if(dept.getDeptId()==1){
                vipExamine.setManageId(user.getId());
                vipExamine.setManageOpinion(0);
                String qrCode = qrCodeUtils.createQrCode(JSONUtil.toJsonStr(vipExamine));
                vipExamine.setCode(qrCode);
            }
        }else{
            //不是部长
            vipExamine = VipExamine.builder().appointmentId(appointmentId).build();
        }
        vipExamineMapper.insert(vipExamine);
        return Result.ok();
    }

    @Override
    public Result vipExamine(VipExamine vipExamine) {
        //全部都同意
        if(!ObjectUtils.isEmpty(vipExamine.getManageOpinion())
                && !ObjectUtils.isEmpty(vipExamine.getManageId())){
            String qrCode = qrCodeUtils.createQrCode(String.valueOf(vipExamine.getId()));
            vipExamine.setCode(qrCode);
        }
        vipExamineMapper.updateById(vipExamine);
        return Result.ok();

    }

    @Override
    public Result vipVisiteEnd(Long id) {
        LambdaUpdateWrapper<VipExamine> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(VipExamine::getAppointmentId,id);
        VipExamine vipExamine = vipExamineMapper.selectOne(wrapper);
        vipExamine.setIsgo(0);
        vipExamineMapper.updateById(vipExamine);
        return Result.ok();
    }
}
