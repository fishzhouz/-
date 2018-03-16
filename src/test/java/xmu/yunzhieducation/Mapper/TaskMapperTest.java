package xmu.yunzhieducation.Mapper;
import org.assertj.core.error.ShouldBeInSameYear;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Student_question;
import xmu.yunzhieducation.mapper.TaskMapper;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testSelectStudentquestionBycourseID()
    {
        List<Student_question>  wrong_question=taskMapper.selectStudentquestionBycourseID(new BigInteger("3"),new BigInteger("1"));
        for(Student_question s:wrong_question)
        {
            System.out.println(s);
        }
    }
}
