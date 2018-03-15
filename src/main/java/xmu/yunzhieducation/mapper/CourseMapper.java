package xmu.yunzhieducation.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Class1;
import xmu.yunzhieducation.entity.Course;

import java.math.BigInteger;
import java.util.List;

/**
 * Course Mapper
 * 注意，每个mapper要给其加上一个@Mapper的注解。
 * 且每个mapper都是接口，实现是由mybatis做的,不需要我们实现。
 */
@Mapper
@Component
public interface CourseMapper {
    /**
     *创建新课程
     */
    void  creatCourse(Course course);
    /**
     * 学生选课
     */
    void chooseCourseByStudentID(BigInteger student_id, BigInteger class_id);
    /**
     * 删除课程
     */
    void deleteCourseByCourseID(BigInteger course_id);
    /**
     * 根据课程ID退课
     */
    void dropCourseByCourseID(BigInteger course_id);
    /**
     * 根据课程ID查看课程信息
     */
    Course selectCourseinfoByCourseID(BigInteger course_id);
    /**
     * 根据课程ID修改课程信息
     */
    void updateCourseinfoByCourseID(Course course);
    /**
     * 根据学生ID查找班级
     */
    List<Class1> selectClassByStudentID(BigInteger user_id);
    /**
     * 根据班级ID查找课程
     */
    List<Course> selectCourseByClassID(BigInteger class_id);
    /**
     * 根据老师ID查找课程
     */
    List<Course> selectCourseByTeacherID(BigInteger teacher_id);

}
