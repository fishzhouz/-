package xmu.yunzhieducation.service;
import org.assertj.core.error.ShouldBeInSameYear;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.service.Impl.CourseServiceImpl;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @Test
    public void testGetOwnCourse() {
        List<CourseAndTeacherVo> courseAndTeacherVos = courseServiceImpl.getOwnCourse(new BigInteger("2"), 1);
        for (CourseAndTeacherVo c : courseAndTeacherVos) {
            System.out.println(c);
        }
    }

    @Test
    public void testGetCourseInfo() {
        System.out.println(courseServiceImpl.getCourseInfo(new BigInteger("4"), new BigInteger("2")));
    }

    @Test
    public void testChooseCourse()
    {
        System.out.println(courseServiceImpl.chooseCourse(new BigInteger("4"),new BigInteger("2")));
    }
}
