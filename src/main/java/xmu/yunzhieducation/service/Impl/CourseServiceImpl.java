package xmu.yunzhieducation.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.Class1;
import xmu.yunzhieducation.entity.Class_student;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.service.CourseService;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;
import xmu.yunzhieducation.vo.CourseInfoVo;

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
                courseAndTeacherVo.setClass_id(c.getClass_id());
                BigInteger course_id=courseMapper.selectCourseIDByClassID(c.getClass_id()).getCourse_id();
                Course course=courseMapper.selectCourseinfoByCourseID(course_id);
                courseAndTeacherVo.setCourse_id(course_id);
                courseAndTeacherVo.setCourse_name(course.getName());
                courseAndTeacherVo.setPicture(course.getPicture());
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
               courseAndTeacherVo.setClass_id(null);
               courseAndTeacherVo.setCourse_id(c.getId());
               courseAndTeacherVo.setCourse_name(c.getName());
               courseAndTeacherVo.setPicture(c.getPicture());
               courseAndTeacherVo.setTeacher_name(name);
               courseAndTeacherVos.add(courseAndTeacherVo);
            }
            return courseAndTeacherVos;
        }
       return null;
    }

    @Override
    public CourseInfoVo getCourseInfo(BigInteger user_id,BigInteger course_id)
    {
        CourseInfoVo courseInfoVo=new CourseInfoVo();
        List<Class1> class1s=courseMapper.selectClassByCourseID(course_id);
        Integer sum=0;
        for(Class1 c:class1s){
            sum+=c.getStudent_num();
        }
        courseInfoVo.setNum(sum);
        courseInfoVo.setCourse(courseMapper.selectCourseinfoByCourseID(course_id));
        List<Class_student> class_students=courseMapper.selectClassstudentByStudentID(user_id);
        boolean temp=false;
        for(Class_student c:class_students)
        {
            for(Class1 class1:class1s)
            {
                if(class1.getId()==c.getClass_id())
                {
                    temp=true;
                    break;
                }
            }
        }
        courseInfoVo.setIs_choose(temp);
        return courseInfoVo;
    }

    @Override
    public boolean chooseCourse(BigInteger user_id,BigInteger class_id)
    {
        Class_student class_student=new Class_student();
        class_student.setClass_id(class_id);
        class_student.setStudent_id(user_id);
        courseMapper.chooseCourseByStudentID(class_student);
        //选完课之后班级人数加一
        courseMapper.updateClass(class_id);
        return true;
    }
}
