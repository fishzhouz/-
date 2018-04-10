package xmu.yunzhieducation.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.PeriodMapper;
import xmu.yunzhieducation.mapper.TaskMapper;
import xmu.yunzhieducation.service.TaskService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private PeriodMapper periodMapper;


    /*
     *获取当前用户在某一课程下的所有任务
     *
     */
    @Override
    public List<Task> getTask(BigInteger course_id){
        // List<Student_period> student_periods=periodMapper.

        Date day=new Date();//获取当前日期
        List<Class1> classes=courseMapper.selectClassByCourseID(course_id);//找到课程下的所有班级

        Class1 class1=new Class1();
        for(int i=0;i<classes.size();i++)
            if(classes.get(i).getStart_time().before(day)&&classes.get(i).getEnd_time().after(day)){
                class1=classes.get(i);//找到课程下唯一的在运行的班级
                break;
            }

        List<Period> periods=periodMapper.selectPeriodByClassID(class1.getId()); //找到班级下的所有课时

        List<Task> tasks=new ArrayList<>();
        for(int i=0;i<periods.size();i++)
            tasks.addAll(taskMapper.selectTaskByperiodID(periods.get(i).getId()));//找到每个课时下的所有练习
        return tasks;
    }


    /*
     *获取某一任务的具体信息
     *
     */
    @Override
    public Task getTaskInfo(BigInteger task_id){
        Task task=taskMapper.selectTaskBytaskID(task_id);
        return task;
    }

    /*
     *获取任务下的所有问题
     *
     */
    @Override
    public List<Question> getQuestionBytaskID(BigInteger task_id){
        List<Question> questions=taskMapper.selectQuestionBytaskID(task_id);
        return questions;
    }


    /*
    答题，并将答案上传
     */
    @Override
    public void insertStudentQuestion(Student_question student_question){

        Question question=taskMapper.selectQuestionByquestionID(student_question.getQuestion_id());
        Task task=taskMapper.selectTaskBytaskID(question.getTask_id());
        Period period=periodMapper.selectPeriodByPeriodID(task.getPeriod_id());
        Class1 class1=courseMapper.selectCourseIDByClassID(period.getClass_id());

        student_question.setCourse_id(class1.getCourse_id());
        taskMapper.insertStudentquestionBycourseID(student_question);
    }

    /*
    删除任务,以及任务下的问题、student_task、student_question
     */
    @Override
    public void deleteTask(BigInteger task_id){
        List<Question> questions=taskMapper.selectQuestionBytaskID(task_id);
        for(int i=0;i<questions.size();i++) {
            taskMapper.deleteStudentquestionByquestionID(questions.get(i).getId());
            taskMapper.deleteQuestionByquestionID(questions.get(i).getId());
        }
        taskMapper.deleteStudenttaskBytaskID(task_id);
        taskMapper.deleteTaskBytaskID(task_id);
    }

    /*
     *上传题目
     *
     */
    public void insertQuestion(Question question){
        taskMapper.insertQuestionBytaskID(question);
    }
    /*
     *删除题目
     */
    public void deleteQuestion(BigInteger question_id){
        taskMapper.deleteQuestionByquestionID(question_id);
    }
}
