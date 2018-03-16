package xmu.yunzhieducation.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Question;
import xmu.yunzhieducation.entity.Student_question;
import xmu.yunzhieducation.entity.Student_task;
import xmu.yunzhieducation.entity.Task;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface TaskMapper {
    /**
     * 新增任务
     */
    void insertTaskByID(Task task);
    /**
     * 删除任务
     */
    void deleteTaskBytaskID(@Param("task_id") BigInteger task_id);
    /**
     * 根据课时选任务
     */
    List<Task> selectTaskByperiodID(@Param("period_id") BigInteger period_id);
    /**
     * 任务中新增题目
     */
    void insertQuestionBytaskID(Question question);
    /**
     * 根据任务选全部的题目
     */
    List<Question> selectQuestionBytaskID(@Param("task_id") BigInteger task_id);
    /**
     * 删除题目
     */
    void deleteQuestionByquestionID(@Param("question_id") BigInteger question_id);
    /**
     * 根据学生和任务去找该次任务学生是否做过
     */
    Student_task selectStudenttaskByID(@Param("student_id") BigInteger student_id,@Param("task_id") BigInteger task_id);
    /**
     * 做过任务后插入student_task表中
     */
    void insertStudenttaskByID(Student_task student_task);
    /**
     * 把课程题目插入学生题库中
     */
    void insertStudentquestionBycourseID(Student_question student_question);
    /**
     * 查看学生课程的错题库
     */
    List<Student_question> selectStudentquestionBycourseID(@Param("user_id") BigInteger user_id,@Param("course_id") BigInteger course_id);
    /**
     * 查看学生具体某道题的情况
     */
    Student_question selectStudentquestionID(@Param("user_id") BigInteger user_id,@Param("question_id") BigInteger question_id);
}
