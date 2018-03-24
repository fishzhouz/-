package xmu.yunzhieducation.service;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.vo.*;

import java.math.BigInteger;
import java.util.List;

@Component
public interface CourseService {
    /**
     * 获取学生的全部课程，同时区分进行中和已完成，同时返回成绩
     */
     List<CourseAndTeacherVo> getOwnCourse(BigInteger user_id);
    /**
     * 获取老师下的全部课程
     */
    List<CourseVo>  getTeacherCourse(BigInteger user_id);
    /**
     * 查看某门课程的课程信息   /course/{course_id} GET
     */
    CourseInfoVo getCourseInfo(BigInteger user_id, BigInteger course_id);
    /**
     * 用户选课,选课后班级人数加一    /course/{class_id}/choose POST
     */
    boolean chooseCourse(BigInteger user_id,BigInteger class_id);
    /**
     * 获取用户当前课程班级下的课时  /course/{class_id}/period  GET
     */
    List<PeriodInfoVo> getOwnPeriod(BigInteger class_id, BigInteger user_id);
    /**
     * 获取用户当前课程班级下的任务  /course/{class_id}/task GET
     */
   List<TaskVo> getOwnTask(BigInteger class_id);
    /**
     * 获取用户当前课程下的错题 /course/{course_id}/error GET
     */
}
