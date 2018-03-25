package xmu.yunzhieducation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Period;
import xmu.yunzhieducation.entity.Student_period;

import java.math.BigInteger;
import java.util.List;

/**
 * Period Mapper
 * 注意，每个mapper要给其加上一个@Mapper的注解。
 * 且每个mapper都是接口，实现是由mybatis做的,不需要我们实现。
 */
@Mapper
@Component
public interface PeriodMapper {
    /**
    * 点击新建课时输入名称为新建一个课时
     */
    void createPeriod(Period period);
    /**
     * 删除一个课时
     */
    void deletePeriodByPeriodID(@Param("period_id") BigInteger period_id);
    /**
     * 上传课件时更改课时里的ppt和视频
     */
    void updatePeriodByPeriodID(Period period);
    /**
     * 根据班级ID选择课时
     */
    List<Period> selectPeriodByClassID(@Param("class_id") BigInteger class_id);
    /**
     * 根据学生ID和课时ID选择,DateMapper中的listStudentPeriodByPeriodIdAndStudentId,有冗余
     */
    /**
     * 修改is_click
     */
    void updateStudentPeriodisclick(@Param("student_id") BigInteger student_id, @Param("period_id") BigInteger period_id);
    /**
     * 插入学生课时记录
     */
    void insertStudentPeriod(Student_period student_period);
    /**
     * 学生退课时,根据课时ID删除学生课时记录
     */
    void deleteStudentPeriodByStudentIDPeriodID(@Param("student_id") BigInteger student_id, @Param("period_id") BigInteger period_id);
    /**
     * 根据课时ID选择课时信息
     */
    Period selectPeriodByPeriodID(@Param("period_id") BigInteger period_id);
    /**
     * 老师删除课时时，删除学生课时信息
     */
    void deleteStudentPeriodByPeriodID( @Param("period_id") BigInteger period_id);
}
