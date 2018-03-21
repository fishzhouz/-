package xmu.yunzhieducation.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Student_training;
import xmu.yunzhieducation.entity.Trainging;
import xmu.yunzhieducation.mapper.TrainingMapper;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingMapperTest {
    @Autowired
    private TrainingMapper trainingMapper;

    @Test
    public void testInsertTraining()
    {
        Trainging t=new Trainging();
        t.setCourse_id(new BigInteger("1"));
        t.setStudent_num(0);
        t.setStart_time(new Date(118,3,20));
        t.setEnd_time(new Date(118,3,30));
        t.setTraing_introduction("java代码实践");
        trainingMapper.insertTraining(t);
    }

    @Test
    public void testUpdateTraining()
    {
        trainingMapper.updateTraining(new BigInteger("2"));
    }

    @Test
    public void testListTrainingByCourseId()
    {
        List<Trainging> traingings=trainingMapper.listTrainingByCourseId(new BigInteger("1"));
        for(Trainging t:traingings){
            System.out.println(t);
        }
    }

    @Test
    public void testListTrainingByTrainingId()
    {
        Trainging t=trainingMapper.listTrainingByTrainingId(new BigInteger("1"));
        System.out.println(t);
    }

    @Test
    public void testInsertStudentTraining()
    {
        Student_training s=new Student_training();
        s.settraining_id(new BigInteger("2"));
        s.setStudent_id(new BigInteger("3"));
        s.setReport("../../..1.waord");
        trainingMapper.insertStudentTraining(s);
    }

    @Test
    public void testUpdateStudentTrainingScoreByStudentIdAndTrainingId()
    {
        Student_training s=new Student_training();
        s.settraining_id(new BigInteger("2"));
        s.setStudent_id(new BigInteger("3"));
        s.setScore(98);
        trainingMapper.updateStudentTrainingScoreByStudentIdAndTrainingId(s);
    }

    @Test
    public void testListStudentTrainingByStudentIdAndTrainingId()
    {
        Student_training s=trainingMapper.listStudentTrainingByStudentIdAndTrainingId(new BigInteger("3"),new BigInteger("1"));
        System.out.println(s);
    }

    @Test
    public void testListStudentTrainingByTrainingId()
    {
        List<Student_training> student_trainings=trainingMapper.listStudentTrainingByTrainingId(new BigInteger("1"));
        for(Student_training s:student_trainings) {
            System.out.println(s);
        }
    }
}
