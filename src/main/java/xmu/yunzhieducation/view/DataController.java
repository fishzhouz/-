package xmu.yunzhieducation.view;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.entity.Ablity_file;
import xmu.yunzhieducation.entity.Student_training;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.service.DataService;
import xmu.yunzhieducation.vo.ParticipationVo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
public class DataController {


    @Autowired
    private DataService dataService;

    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/grade/{student_id}/{class_id}",method = RequestMethod.GET)
    @ResponseBody
    public int getGradeByCourseIDStudentID(@PathVariable("class_id") BigInteger class_id,@PathVariable("student_id") BigInteger student_id){
        return dataService.getGradeByCourseIDStudentID(class_id,student_id);
    }



    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/ablility/{student_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Ablity_file> getAbilityfileByStudentID(@PathVariable("student_id") BigInteger student_id){
        return dataService.getAbilityfileByStudentID(student_id);
    }



    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/ablility/{course_id}/course",method = RequestMethod.GET)
    @ResponseBody
    public List<Ablity_file> getAbilityfileByCourseID(@PathVariable("course_id") BigInteger course_id){
        return dataService.getAbilityfileBycourseID(course_id);
    }


    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/ablility/{course_id}/{student_id}",method = RequestMethod.GET)
    @ResponseBody
    public Ablity_file getAbilityfileByCourseIDAndStudentID(@PathVariable("course_id") BigInteger course_id,@PathVariable("student_id")BigInteger student_id){
        return dataService.getAbilityfileBycourseIDAndStudentID(course_id,student_id);
    }



    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/ablility/{course_id}/{student_id}",method = RequestMethod.POST)
    @ResponseBody
    public void insertAbilityfileByStudentID(@PathVariable("course_id")BigInteger course_id,@PathVariable("student_id")BigInteger student_id,@RequestBody String comment){
        Ablity_file ablity_file=new Ablity_file();
        ablity_file.setCourse_id(course_id);
        ablity_file.setStudent_id(student_id);
        ablity_file.setComment(comment);
        ablity_file.setTime(new Date());
        dataService.insertAbilityfileByStudentID(ablity_file);
    }


    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/data/student/{class_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllStudentByClassID(@PathVariable("class_id") BigInteger class_id){
        return dataService.getAllStudentByClassID(class_id);
    }




    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/data/training/{training_id}",method = RequestMethod.GET)
    @ResponseBody
    public ParticipationVo trainingparticipationByTrainingID(@PathVariable("training_id") BigInteger training_id){
        return dataService.trainingparticipationByTrainingID(training_id);
    }




    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/data/training/{training_id}/grade",method = RequestMethod.GET)
    @ResponseBody
    public List<Student_training> getAllGradeByTrainingID(@PathVariable("training_id") BigInteger training_id){
        return dataService.getAllGradeByTrainingID(training_id);
    }
}
