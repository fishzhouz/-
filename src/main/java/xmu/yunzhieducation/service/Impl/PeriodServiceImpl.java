package xmu.yunzhieducation.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.Period;
import xmu.yunzhieducation.entity.Student_period;
import xmu.yunzhieducation.entity.Task;
import xmu.yunzhieducation.mapper.PeriodMapper;
import xmu.yunzhieducation.mapper.TaskMapper;
import xmu.yunzhieducation.service.PeriodService;
import xmu.yunzhieducation.service.TaskService;

import java.math.BigInteger;
import java.util.List;

@Service
public class PeriodServiceImpl implements PeriodService{

    @Autowired
    private PeriodMapper periodMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskService taskService;

    /*
     *获取课时信息
     */
    public Period getPeriod(BigInteger period_id){
        Period period=periodMapper.selectPeriodByPeriodID(period_id);
        return period;
    }
    /*
     *删除课时
     */
    public void deletePeriod(BigInteger period_id){
        List<Task> tasks=taskMapper.selectTaskByperiodID(period_id);
        for(int i=0;i<tasks.size();i++){
            taskService.deleteTask(tasks.get(i).getId());
        }
        periodMapper.deleteStudentPeriodByPeriodID(period_id);
        periodMapper.deletePeriodByPeriodID(period_id);
    }
    /*
     *修改课时信息
     */
    public void updatePeriod(Period period){
        periodMapper.updatePeriodByPeriodID(period);
    }
    /*
     *新建课时
     */
    public void postPeriod(Period period){
        periodMapper.createPeriod(period);
    }
    /*
     *获取班级下的所有课时
     */
    public List<Period> getPeriodByClassID(BigInteger class_id){
        List<Period> periods=periodMapper.selectPeriodByClassID(class_id);
        return periods;
    }
    /*
     *记录学生课时信息
     */
    public void insertStdentPeriod(BigInteger student_id,BigInteger period_id){
        Student_period student_period=new Student_period();
        student_period.setIs_click(1);
        student_period.setPeriod_id(period_id);
        student_period.setStudent_id(student_id);
        periodMapper.insertStudentPeriod(student_period);
    }
}
