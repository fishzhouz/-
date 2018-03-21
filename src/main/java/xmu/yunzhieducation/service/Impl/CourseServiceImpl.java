package xmu.yunzhieducation.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.Class_student;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.service.CourseService;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LoginMapper loginMapper;

    @Override
   public List<CourseAndTeacherVo> getOwnCourse(BigInteger user_id, Integer type)
    {
       List<CourseAndTeacherVo> courseAndTeacherVos=new ArrayList<CourseAndTeacherVo>();
        if(type==0)//学生
        {
            List<Class_student> class_students=courseMapper.selectClassstudentByStudentID(user_id);
            for(Class_student c:class_students)
            {
                CourseAndTeacherVo courseAndTeacherVo=new CourseAndTeacherVo();
                BigInteger course_id=courseMapper.selectCourseIDByClassID(c.getClass_id()).getCourse_id();
                Course course=courseMapper.selectCourseinfoByCourseID(course_id);
                courseAndTeacherVo.setCourse_name(course.getName());
                courseAndTeacherVo.setTeacher_name(loginMapper.selectUserByuserID(course.getTeacher_id()).getName());
                courseAndTeacherVos.add(courseAndTeacherVo);
            }
            return courseAndTeacherVos;
        }
        else if(type==1)//老师
        {
            List<Course> courses=courseMapper.selectCourseByTeacherID(user_id);
            String name=loginMapper.selectUserByuserID(user_id).getName();
            for(Course c:courses){
               CourseAndTeacherVo courseAndTeacherVo=new CourseAndTeacherVo();
               courseAndTeacherVo.setCourse_name(c.getName());
               courseAndTeacherVo.setTeacher_name(name);
               courseAndTeacherVos.add(courseAndTeacherVo);
            }
            return courseAndTeacherVos;
        }
       return null;
    }
}
