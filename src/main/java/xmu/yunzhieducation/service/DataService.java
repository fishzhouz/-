package xmu.yunzhieducation.service;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.*;

import java.math.BigInteger;
import java.util.List;

@Component
public interface DataService {
    /**
     * 查看学生某门课的成绩
     */
    int getGradeByCourseIDStudentID(BigInteger course_id,BigInteger student_id);
    /**
     *老师或学校查看某个学生的能力档案
     */
    List<Ablity_file> getAbilityfileByStudentID(BigInteger student_id);
    /**
     * 学生查看自己的能力档案
     */
    List<Ablity_file> getownAbilityfileByStudentID(BigInteger student_id);
    /**
     * 根据学生ID和课程ID给某学生添加能力评价
     */
    void insertAbilityfileByStudentID(BigInteger student_id, BigInteger course_id);
    /**
     * 老师获取某门课程下某班级的所有学生
     */
    List<User> getAllStudentByClassID(BigInteger class_id);
    /**
     *获取某个实训下的参与度分析（包括应参与人数和已参与人数）
     */
    double trainingparticipationByTrainingID(BigInteger training_id);
    /**
     * 获得某个实训下的所有学生的得分
     */
    List<int> getAllGradeByTrainingID(BigInteger training_id);
}
