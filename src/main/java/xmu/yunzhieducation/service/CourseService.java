package xmu.yunzhieducation.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;
import xmu.yunzhieducation.vo.CourseInfoVo;

import java.math.BigInteger;
import java.util.List;

@Component
public interface CourseService {
    /**
     * 获取学生的全部课程（type0)或老师的全部课程（type1）  传回课程名字和老师名字
     */
     List<CourseAndTeacherVo> getOwnCourse(BigInteger user_id,Integer type);
    /**
     * 查看某门课程的课程信息   /course/{course_id} GET
     */
    CourseInfoVo getCourseInfo(BigInteger user_id, BigInteger course_id);
    /**
     * 用户选课,选课后班级人数加一    /course/{class_id}/choose POST
     */
    boolean chooseCourse(BigInteger user_id,BigInteger class_id);
}
