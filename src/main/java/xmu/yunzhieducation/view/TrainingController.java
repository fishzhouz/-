package xmu.yunzhieducation.view;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.service.Impl.CommentServiceImpl;

import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.service.Impl.TrainingServiceImpl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
public class TrainingController {
    @Autowired
    private TrainingServiceImpl trainingServiceImpl;

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
    public Trainging getTrainingByTrainingId(@PathVariable BigInteger training_id){
        return trainingServiceImpl.GetTrainingByTrainingId(training_id);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("training/{training_id}/upload"),method=RequestMethod.POST)
    @ResponseBody
    //测试完毕
    public Boolean uploadTrainingReport(@PathVariable BigInteger training_id
            ,@RequestParam String report,@CookieValue BigInteger user_id){
        Student_training st=new Student_training();
        st.setReport(report);
        st.setStudent_id(user_id);
        st.settraining_id(training_id);
        return trainingServiceImpl.UploadTrainingReport(st);
    }
}