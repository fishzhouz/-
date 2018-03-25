package xmu.yunzhieducation.view;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.entity.Question;
import xmu.yunzhieducation.entity.Task;
import xmu.yunzhieducation.service.TaskService;
import xmu.yunzhieducation.vo.Task2Vo;

import java.math.BigInteger;
import java.util.List;

@RestController
public class TaskController {




    @Autowired
    private TaskService taskService;





    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/task/{course_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getTask(@PathVariable("course_id")BigInteger course_id){
        return taskService.getTask(course_id);
    }






    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/task/{task_id}/info",method = RequestMethod.GET)
    @ResponseBody
    public Task2Vo getTaskInfo(@PathVariable("task_id")BigInteger task_id){
        Task2Vo task2Vo =new Task2Vo();
        Task task=taskService.getTaskInfo(task_id);
        task2Vo.setId(task.getId());
        task2Vo.setName(task.getName());
        task2Vo.setEnd_time(task.getEnd_time());
        task2Vo.setInformation(task.getInformation());
        task2Vo.setPeriod_id(task.getPeriod_id());
        task2Vo.setStart_time(task.getStart_time());
        task2Vo.setType(task.getType());
        task2Vo.setWord_file(task.getWord_file());
        List<Question> questions=taskService.getQuestionBytaskID(task_id);
        for(int i=0;i<questions.size();i++)
            if(!(questions.get(i).getAnswer()>='A'&&questions.get(i).getAnswer()<='D')){
                task2Vo.setIs_finished(1);
                return task2Vo;
            }
        task2Vo.setIs_finished(0);
        return task2Vo;
    }







    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/task/{task_id}/question",method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQuestionBytaskID(@PathVariable("task_id")BigInteger task_id){
        return taskService.getQuestionBytaskID(task_id);
    }








    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/task/{question_id}/{answer}",method = RequestMethod.POST)
    @ResponseBody
    public void insertStudentQuestion(@PathVariable("question_id")BigInteger question_id,@PathVariable("answer")char answer,@RequestParam(value = "user_id") BigInteger user_id){
        taskService.insertStudentQuestion(question_id,answer,user_id);
    }







    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/task/{task_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("task_id")BigInteger task_id){
        taskService.deleteTask(task_id);
    }


    /*
     *未测试
     */
    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/task/{task_id}/question",method = RequestMethod.POST)
    @ResponseBody
    public void insertStudentQuestion(@PathVariable("task_id")BigInteger task_id,@RequestBody Question question){
        question.setTask_id(task_id);
        taskService.insertQuestion(question);
    }


    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/task/question/{question_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteQuestion(@PathVariable("question_id")BigInteger question_id){
        taskService.deleteQuestion(question_id);
    }

}
