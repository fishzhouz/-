package xmu.yunzhieducation.view;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.entity.Question;
import xmu.yunzhieducation.entity.Student_question;
import xmu.yunzhieducation.entity.Student_task;
import xmu.yunzhieducation.entity.Task;
import xmu.yunzhieducation.mapper.TaskMapper;
import xmu.yunzhieducation.service.TaskService;
import xmu.yunzhieducation.vo.Task2Vo;
import xmu.yunzhieducation.vo.WrongQuestionVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {




    @Autowired
    private TaskService taskService;

@Autowired
private TaskMapper taskMapper;



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
    public Task getTaskInfo(@PathVariable("task_id")BigInteger task_id){
        Task task=taskService.getTaskInfo(task_id);
        return task;
    }







    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/task/{task_id}/question",method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQuestionBytaskID(@PathVariable("task_id")BigInteger task_id){
        return taskService.getQuestionBytaskID(task_id);
    }


    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/task/{task_id}/judge",method = RequestMethod.GET)
    @ResponseBody
    public boolean taskID(@PathVariable("task_id")BigInteger task_id,@RequestParam(value="user_id") BigInteger user_id){
        Student_task student_task=taskMapper.selectStudenttaskByID(user_id,task_id);
        if(student_task==null)
            return false;
        else
            return true;
    }

    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/task/{task_id}/own",method = RequestMethod.GET)
    @ResponseBody
    public List<WrongQuestionVo> getStudentQuestionByID(@PathVariable("task_id")BigInteger task_id, @RequestParam(value="user_id") BigInteger user_id){
        List<WrongQuestionVo> wrongQuestionVos=new ArrayList<>();
        List<Question> questions=taskMapper.selectQuestionBytaskID(task_id);
        for(Question q:questions) {
            WrongQuestionVo wrongQuestionVo=new WrongQuestionVo();
            wrongQuestionVo.setA(q.getA());
            wrongQuestionVo.setB(q.getB());
            wrongQuestionVo.setC(q.getC());
            wrongQuestionVo.setD(q.getD());
            wrongQuestionVo.setHeading(q.getHeading());
            wrongQuestionVo.setAnswer(q.getAnswer());
            wrongQuestionVo.setWrong_answer(taskMapper.selectStudentquestionByquestionID(user_id,q.getId()).getOwn_answer());
            wrongQuestionVos.add(wrongQuestionVo);
        }
        return wrongQuestionVos;
    }



    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/task/answer",method = RequestMethod.POST)
    @ResponseBody
    public void insertStudentQuestion(@RequestBody Student_question student_question){
        taskService.insertStudentQuestion(student_question);
    }

    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/task/answer2",method = RequestMethod.POST)
    @ResponseBody
    public void insertStudentTask(@RequestBody Student_task student_task){
        taskMapper.insertStudenttaskByID(student_task);
    }





    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/task/{task_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("task_id")BigInteger task_id){
        taskService.deleteTask(task_id);
    }



    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/task/{task_id}/question",method = RequestMethod.POST)
    @ResponseBody
    public void insertStudentQuestion(@PathVariable("task_id")BigInteger task_id,@RequestBody Question question){
        question.setTask_id(task_id);
        taskService.insertQuestion(question);
    }

    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/task",method = RequestMethod.POST)
    @ResponseBody
    public void insertTask(@RequestBody Task task){
        taskMapper.insertTaskByID(task);
    }
    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/task/question",method = RequestMethod.POST)
    @ResponseBody
    public void insertQuestion(@RequestBody Question question){
        taskMapper.insertQuestionBytaskID(question);
    }

    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/task/question/{question_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteQuestion(@PathVariable("question_id")BigInteger question_id){
        taskService.deleteQuestion(question_id);
    }

}
