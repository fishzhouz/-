package xmu.yunzhieducation.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.*;
import xmu.yunzhieducation.service.CourseService;
import xmu.yunzhieducation.vo.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private PeriodMapper periodMapper;
    @Autowired
    private DateMapper dateMapper;
    @Autowired
    private TaskMapper taskMapper;

    @Override
   public List<CourseAndTeacherVo> getOwnCourse(BigInteger user_id)
    {
       List<CourseAndTeacherVo> courseAndTeacherVos=new ArrayList<CourseAndTeacherVo>();
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
                if(c.getGrade()==null)  {
                    courseAndTeacherVo.setIs_end(false);
                    courseAndTeacherVo.setReplay("进行中");
                }
                else{
                    courseAndTeacherVo.setIs_end(true);
                    courseAndTeacherVo.setReplay("已结束  "+c.getGrade()+"分");
                }
                courseAndTeacherVos.add(courseAndTeacherVo);
            }
            return courseAndTeacherVos;
    }

    @Override
    public List<CourseVo> getTeacherCourse(BigInteger user_id)
    {
        List<CourseVo> courseVos=new ArrayList<CourseVo>();
        List<Course> courses=courseMapper.selectCourseByTeacherID(user_id);
        String name=loginMapper.selectUserByuserID(user_id).getName();
        for(Course c:courses){
            CourseVo courseVo=new CourseVo();
            courseVo.setCourse_id(c.getId());
            courseVo.setCourse_name(c.getName());
            courseVo.setPicture(c.getPicture());
            courseVo.setTeacher_name(name);
            courseVos.add(courseVo);
        }
        return courseVos;
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

    @Override
    public List<PeriodInfoVo> getOwnPeriod(BigInteger class_id, BigInteger user_id)
    {
        List<PeriodInfoVo> periodInfoVos =new ArrayList<PeriodInfoVo>();
        List<Period> periods=periodMapper.selectPeriodByClassID(class_id);
        Integer index=1;
        for(Period p:periods)
        {
            PeriodInfoVo periodInfoVo =new PeriodInfoVo();
            periodInfoVo.setPeriod_id(p.getId());
            periodInfoVo.setContent("第"+index+"课时  "+p.getKnowledge_point());
            index+=1;
            Student_period s=dateMapper.listStudentPeriodByPeriodIdAndStudentId(p.getId(),user_id);
            if(s==null){
                periodInfoVo.setIs_click(false);
            }
            else{
                periodInfoVo.setIs_click(true);
            }
            periodInfoVos.add(periodInfoVo);
        }
        return periodInfoVos;
    }

    @Override
    public List<TaskVo> getOwnTask(BigInteger class_id)
    {
        List<TaskVo> taskVos=new ArrayList<>();
        List<Period> periods=periodMapper.selectPeriodByClassID(class_id);
        Integer index=1;
        for(Period p:periods){
            List<Task> tasks=taskMapper.selectTaskByperiodID(p.getId());
            for(Task t:tasks){
                TaskVo taskVo=new TaskVo();
                taskVo.setTask_id(t.getId());
                taskVo.setContent("任务"+index+"  "+t.getName());
                index+=1;
                taskVos.add(taskVo);
            }
        }
        return taskVos;
    }
}
