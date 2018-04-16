package xmu.yunzhieducation.view;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.mapper.TrainingMapper;
import xmu.yunzhieducation.service.Impl.CommentServiceImpl;

import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.service.Impl.TrainingServiceImpl;
import xmu.yunzhieducation.vo.TraingingVo;
import xmu.yunzhieducation.vo.TraingingVo2;
import xmu.yunzhieducation.vo.TraingingVo3;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
public class TrainingController {
    @Autowired
    private TrainingServiceImpl trainingServiceImpl;
    @Autowired
    private TrainingMapper trainingMapper;

    @ResponseStatus(value=HttpStatus.OK)
    @RequestMapping(value=("/training/course/{course_id}"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public List<Trainging> getAllTrainingByUserId(@PathVariable BigInteger course_id){
        return trainingServiceImpl.GetTrainingByCourseId(course_id);
    }

    @ResponseStatus(value=HttpStatus.OK)
    @RequestMapping(value=("/training/{training_id}"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public TraingingVo getTrainingByTrainingId(@PathVariable BigInteger training_id, @RequestParam(value = "user_id") BigInteger user_id){
        return trainingServiceImpl.GetTrainingByTrainingId(training_id,user_id);
    }
    @ResponseStatus(value=HttpStatus.OK)
    @RequestMapping(value=("/training1/{training_id}"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public TraingingVo2 getTrainingById(@PathVariable BigInteger training_id){
        return trainingServiceImpl.GetTrainingById(training_id);
    }
    @ResponseStatus(value=HttpStatus.CREATED)
    @RequestMapping(value=("/training/{training_id}/upload"),method=RequestMethod.POST)
    @ResponseBody
    //测试完毕
    public Boolean uploadTrainingReport(@PathVariable BigInteger training_id,@RequestParam(value="user_id") BigInteger user_id,@RequestBody String report){
        Student_training st=new Student_training();
        st.setReport(report);
        st.setStudent_id(user_id);
        st.settraining_id(training_id);
        return trainingServiceImpl.UploadTrainingReport(st);
    }



    @ResponseStatus(value=HttpStatus.CREATED)
    @RequestMapping(value=("/training/{training_id}/grade/{student_id}"),method=RequestMethod.POST)
    @ResponseBody
    public Boolean uploadTrainingGrade(@PathVariable("training_id") BigInteger training_id
            ,@PathVariable("student_id") BigInteger student_id
            ,@RequestParam String grade){
        Student_training st=new Student_training();
        st.setScore(Integer.parseInt(grade));
        st.setStudent_id(student_id);
        st.settraining_id(training_id);
        return trainingServiceImpl.UpdateTrainingReport(st);
    }



    @ResponseStatus(value=HttpStatus.OK)
    @RequestMapping(value=("/training/{training_id}/grade"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public Student_training getStudentTrainingByUserIdTrainingId(@PathVariable("training_id") BigInteger training_id
            ,@RequestParam(value = "user_id") BigInteger user_id){
        return trainingServiceImpl.GetTraingingReport(user_id,training_id);
    }


    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("/training"),method=RequestMethod.POST)
    @ResponseBody
    public Boolean insterTrainingGrade(@RequestBody Trainging trainging){
        return trainingServiceImpl.InsertTraining(trainging);
    }

    @ResponseStatus(value=HttpStatus.OK)
    @RequestMapping(value=("/training2/{training_id}"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public TraingingVo3 getTraining2ById(@PathVariable BigInteger training_id){
        TraingingVo3 traingingVo3=new TraingingVo3();
       Trainging t=trainingMapper.listTrainingByTrainingId(training_id);
       traingingVo3.setName(t.getTraing_introduction());
       traingingVo3.setStart_time(t.getStart_time());
       traingingVo3.setEnd_time(t.getEnd_time());
       traingingVo3.setNum(t.getStudent_num());
       Integer g1=0,g2=0,g3=0,g4=0,g5=0;
       List<Student_training> student_trainings=trainingMapper.listStudentTrainingByTrainingId(training_id);
       for(Student_training s:student_trainings){
           if(s.getScore()<=60&&s.getScore()>=0)  g1++;
           if(s.getScore()<=69&&s.getScore()>=60)  g2++;
           if(s.getScore()<=79&&s.getScore()>=70)  g3++;
           if(s.getScore()<=89&&s.getScore()>=80)  g4++;
           if(s.getScore()<=100&&s.getScore()>=90)  g5++;
       }
       traingingVo3.setG1(g1);
        traingingVo3.setG2(g2);
        traingingVo3.setG3(g3);
        traingingVo3.setG4(g4);
        traingingVo3.setG5(g5);
        return traingingVo3;
    }
}