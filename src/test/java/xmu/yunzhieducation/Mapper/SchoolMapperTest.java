package xmu.yunzhieducation.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.SchoolMapper;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolMapperTest {
    @Autowired
    private SchoolMapper schoolMapper;

    @Test
    public void testInsertSchool()
    {
        School s=new School();
        s.setId(new BigInteger("3"));
        s.setHomepage("fd.edu.cn");
        s.setName("复旦大学");
        s.setProvince("上海");
        s.setCity("上海");
        s.setPicture("/../img");
        schoolMapper.insertSchool(s);
    }

    @Test
    public void testUpdateSchool()
    {
        School s=new School();
        s.setId(new BigInteger("2"));
        s.setHomepage("nk.edu.cn");
        s.setName("南开大学");
        s.setProvince("天津");
        s.setCity("天津");
        s.setPicture("/../南开大学.png");
        schoolMapper.updateSchool(s);
    }

    @Test
    public void testInsertSchoolInfo()
    {
        School_information s=new School_information();
        s.setSchool_id(new BigInteger("1"));
        s.setContent("某知名教授获奖");
        s.setType(0);
        s.setCourse_id(null);
        schoolMapper.insertSchoolInfo(s);
    }

    @Test
    public void testDeleteSchoolinfo()
    {
        schoolMapper.deleteSchoolInfo(new BigInteger("2"));
    }

    @Test
    public void testUpdateSchoolInfo()
    {
        schoolMapper.updateSchoolInfo("互联网+比赛在我校举办",new BigInteger("1"));
    }

    @Test
    public void testInsertClass()
    {
        Class1 c=new Class1();
        c.setCourse_id(new BigInteger("1"));
        c.setClass_name("秋季班");
        c.setStudent_num(0);
        c.setStart_time(new Date(118,8,1));
        c.setEnd_time(new Date(118,11,1));
        schoolMapper.insertClass(c);
    }

    @Test
    public void testDeleteClass()
    {
        schoolMapper.deleteClass(new BigInteger("3"));
    }

    @Test
    public void testUpdateClass()
    {
        Class1 c=new Class1();
        c.setId(new BigInteger("4"));
        c.setClass_name("秋季班");
        c.setStudent_num(1);
        c.setStart_time(new Date(118,8,1));
        c.setEnd_time(new Date(118,11,1));
        schoolMapper.updateClassInfo(c);
    }

    @Test
    public void testListTeacherBySchoolId()
    {
        List<User>  teachers=schoolMapper.listTeacherBySchoolId(new BigInteger("1"));
        for(User t:teachers)
        {
            System.out.println(t);
        }
    }

    @Test
    public void testListAllSchools()
    {
        List<School>  schools=schoolMapper.listAllSchools();
        for(School s:schools)
        {
            System.out.println(s);
        }
    }

    @Test
    public void testListAllCourses()
    {
        List<Course>  courses=schoolMapper.listAllCourses();
        for(Course c:courses)
        {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectSchoolById()
    {
        School  school=schoolMapper.selectSchoolById(new BigInteger("1"));
        System.out.println(school);
    }

    @Test
    public void testSelectInfoByschoolID()
    {
        List<School_information>  school_informations=schoolMapper.selectInfoByschoolID(new BigInteger("1"));
        for(School_information s:school_informations)
        {
            System.out.println(s);
        }
    }

    @Test
    public void testSelectCourseImgByschoolID()
    {
        List<School_information>  school_informations=schoolMapper.selectCourseImgByschoolID(new BigInteger("1"));
        for(School_information s:school_informations)
        {
            System.out.println(s);
        }
    }
}
