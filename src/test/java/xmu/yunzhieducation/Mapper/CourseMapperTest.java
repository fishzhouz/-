package xmu.yunzhieducation.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Class1;
import xmu.yunzhieducation.entity.Class_student;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.mapper.CourseMapper;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMapperTest {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testCreateCourse()
    {
        Course c=new Course();
        c.setId(new BigInteger("3"));
        c.setName("线性代数");
        c.setTeacher_id(new BigInteger("2"));
        c.setIntroduction("数学");
        c.setKnowledge_point("矩阵");
        c.setTeaching_progress("随便");
        c.setPicture("null");
        courseMapper.creatCourse(c);
    }

    @Test
    public void testChoosecourseByStudentID()
    {
        Class_student c=new Class_student();
        c.setId(new BigInteger("9"));
        c.setClass_id(new BigInteger("2"));
        c.setStudent_id(new BigInteger("3"));
        courseMapper.chooseCourseByStudentID(c);
    }

    @Test
    public void testDeleteCourseBycourseID()
    {
        courseMapper.deleteCourseByCourseID(new BigInteger("3"));
    }

    @Test
    public void testDropCourseByClassID()
    {
         courseMapper.dropCourseByClassID(new BigInteger("2"),new BigInteger("3"));
    }

    @Test
    public void testSelectCourseinfoByCourseID()
    {
        Course c=courseMapper.selectCourseinfoByCourseID(new BigInteger("2"));
        System.out.println(c);
    }

    @Test
    public void testUpdateCourseinfoByCourseID()
    {
        Course c=new Course();
        c.setId(new BigInteger("2"));
        c.setName("高数");
        c.setTeacher_id(new BigInteger("2"));
        c.setIntroduction("数学");
        c.setKnowledge_point("大学生最容易挂的课程");
        c.setTeaching_progress("随便");
        c.setPicture("null");
        courseMapper.updateCourseinfoByCourseID(c);
    }

    @Test
    public void testSelectClassstudentByStudentID()
    {
        List<Class_student> class_students=courseMapper.selectClassstudentByStudentID(new BigInteger("5"));
        for(Class_student c:class_students)
        {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectCourseIDByClassID()
    {
        Class1 c=courseMapper.selectCourseIDByClassID(new BigInteger("1"));
        System.out.println(c);
    }

    @Test
    public void testSelectClassByCourseID()
    {
        List<Class1> class1=courseMapper.selectClassByCourseID(new BigInteger("1"));
        for(Class1 c:class1) {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectCourseByTeacherID()
    {
        List<Course> courses=courseMapper.selectCourseByTeacherID(new BigInteger("1"));
        for(Course c:courses) {
            System.out.println(c);
        }
    }
}
