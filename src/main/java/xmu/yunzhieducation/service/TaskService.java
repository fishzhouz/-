package xmu.yunzhieducation.service;

import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Question;
import xmu.yunzhieducation.entity.Student_question;
import xmu.yunzhieducation.entity.Task;

import java.math.BigInteger;
import java.util.List;


@Component
public interface TaskService {

    /*
    根据课程id获取真正进行的班级下的所有的练习
    先根据课程id找到所有的班级，再找到正在进行的班级
    根据班级id找到所有的课时
    根据课时找到所有的练习
     */
    public List<Task> getTask(BigInteger course_id);

    /*
    直接根据taskid找到相应的task的详细情况
     */
    public Task getTaskInfo(BigInteger task_id);

    /*
     *查看任务下的所有题目
     */
    public List<Question> getQuestionBytaskID(BigInteger task_id);

    /*
    答题，并将答案上传
     */
    public void insertStudentQuestion(Student_question student_question);
    /*
    删除任务
     */
    public void deleteTask(BigInteger task_id);
    /*
     *上传题目
     *
     */
    public void insertQuestion(Question question);
    /*
     *删除题目
     */
    public void deleteQuestion(BigInteger question_id);
}
