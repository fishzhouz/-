package xmu.yunzhieducation.service;
import org.assertj.core.error.ShouldBeInSameYear;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void testGetOwnCourse()
    {
        List<CourseAndTeacherVo> courseAndTeacherVos=courseService.getOwnCourse(new BigInteger("3"),0);
        for(CourseAndTeacherVo c:courseAndTeacherVos){
            System.out.println(c);
        }
    }
}
