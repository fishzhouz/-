package xmu.yunzhieducation.service;


import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Period;

import java.math.BigInteger;
import java.util.List;

@Component
public interface PeriodService {
    /*
     *获取课时信息
     */
    public Period getPeriod(BigInteger period_id);
    /*
     *删除课时
     */
    public void deletePeriod(BigInteger period_id);
    /*
     *修改课时信息
     */
    public void updatePeriod(Period period);
    /*
     *新建课时
     */
    public void postPeriod(Period period);
    /*
     *获取班级下的所有课时
     */
    public List<Period> getPeriodByClassID(BigInteger class_id);
    /*
     *记录学生课时信息
     */
    public void insertStdentPeriod(BigInteger student_id,BigInteger period_id);
}
