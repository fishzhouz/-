package xmu.yunzhieducation.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Ablity_file;
import xmu.yunzhieducation.entity.Class_student;
import xmu.yunzhieducation.entity.Period;
import xmu.yunzhieducation.entity.Student_period;
import xmu.yunzhieducation.mapper.DateMapper;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateMapperTest {
    @Autowired
    private DateMapper dateMapper;

    @Test
    public void testListClassStudentByClassId()
    {
         List<Class_student> class_students=dateMapper.listClassStudentByClassId(new BigInteger("1"));
         for(Class_student c:class_students) {
             System.out.println(c);
         }
    }


    @Test
    public void testListClassStudentByClassIdAndStudentId()
    {
        Class_student class_student=dateMapper.listClassStudentByClassIdAndStudentId(new BigInteger("1"),new BigInteger("3"));
        System.out.println(class_student);
    }

    @Test
    public void testListPeriodByClassId()
    {
        List<Period> periods=dateMapper.listPeriodByClassId(new BigInteger("1"));
        for(Period p:periods) {
            System.out.println(p);
        }
    }

    @Test
    public void testListStudentPeriodByPeriodIdAndStudentId()
    {
        Student_period student_period=dateMapper.listStudentPeriodByPeriodIdAndStudentId(new BigInteger("1"),new BigInteger("3"));
        System.out.println(student_period);
    }

    @Test
    public void testInsertAbilityFileByCourseIdAndStudentId()
    {
        Ablity_file a=new Ablity_file();
        a.setTime(new Date(118,3,20,23,23,23));
        a.setComment("这个娃不错");
        a.setCourse_id(new BigInteger("1"));
        a.setStudent_id(new BigInteger("5"));
        dateMapper.insertAbilityFileByCourseIdAndStudentId(a);
    }

    @Test
    public void testListAbilityFileByCourseIdAndStudentId()
    {
        Ablity_file ablity_file=dateMapper.listAbilityFileByCourseIdAndStudentId(new BigInteger("1"),new BigInteger("5"));
        System.out.println(ablity_file);
    }
}