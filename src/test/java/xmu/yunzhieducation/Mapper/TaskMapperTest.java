package xmu.yunzhieducation.Mapper;
import org.apache.ibatis.jdbc.Null;
import org.assertj.core.error.ShouldBeInSameYear;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Question;
import xmu.yunzhieducation.entity.Student_question;
import xmu.yunzhieducation.entity.Student_task;
import xmu.yunzhieducation.entity.Task;
import xmu.yunzhieducation.mapper.TaskMapper;

import java.math.BigInteger;
import java.util.Date;
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

    @Test
    public void testInsertTaskByID()
    {
        Task t=new Task();
        t.setStart_time(new Date(2018,3,17));
        t.setEnd_time(new Date(2018,3,24));
        t.setPeriod_id(new BigInteger("4"));
        t.setName("导数");
        t.setType("练习");
        t.setWord_file("aaaaa");
        taskMapper.insertTaskByID(t);
    }

    @Test
    public void testDeleteTaskBytaskID()
    {
        taskMapper.deleteTaskBytaskID(new BigInteger("5"));
    }

    @Test
    public void testSelectTaskByperiodID()
    {
        List<Task> tasks=taskMapper.selectTaskByperiodID(new BigInteger("1"));
        for(Task task:tasks)
        {
            System.out.println(task);
        }
    }

    @Test
    public void testInsertQuestionBytaskID()
    {
        Question q=new Question();
        q.setHeading("nba夺冠次数最多的球队是？");
        q.setA("凯尔特人");
        q.setB("湖人");
        q.setC("马刺");
        q.setD("火箭");
        q.setAnswer('A');
        q.setTask_id(new BigInteger("1"));
        taskMapper.insertQuestionBytaskID(q);
    }

    @Test
    public void testSelectQuestionBytaskID()
    {
        List<Question> questions=taskMapper.selectQuestionBytaskID(new BigInteger("1"));
        for(Question q:questions) {
            System.out.println(q);
        }
    }

    @Test
    public void testDeleteQuestionByquestionID()
    {
        taskMapper.deleteQuestionByquestionID(new BigInteger("6"));
    }

    @Test
    public void testSelectStudenttaskByID()
    {
        Student_task student_task=taskMapper.selectStudenttaskByID(new BigInteger("3"),new BigInteger("1"));
        System.out.println(student_task);
    }

    @Test
    public void testInsertStudenttaskByID()
    {
        Student_task student_task=new Student_task();
        student_task.setStudent_id(new BigInteger("9"));
        student_task.setTask_id(new BigInteger("3"));
        student_task.setGrade(98);
        taskMapper.insertStudenttaskByID(student_task);
    }

    @Test
    public void testDeleteStudenttaskBystudentID()
    {
        taskMapper.deleteStudenttaskBystudentID(new BigInteger("9"));
    }

    @Test
    public void testInsertStudentquestionBycourseID()
    {
        Student_question s=new Student_question();
        s.setUser_id(new BigInteger("4"));
        s.setQuestion_id(new BigInteger("1"));
        s.setOwn_answer('D');
        s.setIs_true(1);
        s.setCourse_id(new BigInteger("1"));
        taskMapper.insertStudentquestionBycourseID(s);
    }

    @Test
    public void testSelectStudentquestionByquestionID()
    {
        Student_question s=taskMapper.selectStudentquestionByquestionID(new BigInteger("3"),new BigInteger("1"));
        System.out.println(s);
    }

    @Test
    public void testDeleteStudentquestionByuserID()
    {
        taskMapper.deleteStudentquestionByuserID(new BigInteger("4"));
    }
}
