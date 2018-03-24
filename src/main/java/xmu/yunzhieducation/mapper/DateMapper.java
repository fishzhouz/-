package xmu.yunzhieducation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.*;

import java.util.List;

import java.math.BigInteger;
@Mapper
@Component
public interface DateMapper {

    /*根据classId找到班级下的所有学生*/
    List<Class_student> listClassStudentByClassId(@Param("classId")BigInteger classId);


    /*根据classID和studentId找到具体的学生在课程下的表现来查看分数*/
    Class_student listClassStudentByClassIdAndStudentId(@Param("classId")BigInteger classId,@Param("studentId")BigInteger studentId);


    /*根据classId找到班级下的所有的任务*/
    List<Period> listPeriodByClassId(@Param("classId")BigInteger classId);


    /*根据periodId和studentId找到学生在某个课时下的具体表现，已经判断学生是否有参与该课时的学习*/
    Student_period listStudentPeriodByPeriodIdAndStudentId(@Param("periodId")BigInteger periodId,@Param("studentId")BigInteger studentId);


    /*根据courseId和userId上传个人能力档案*/
    void insertAbilityFileByCourseIdAndStudentId(Ablity_file ablityFile);


    /*根据courseId和userId查看个人能力档案*/
    Ablity_file listAbilityFileByCourseIdAndStudentId(@Param("courseId")BigInteger courseId,@Param("studentId")BigInteger studentId);

    /*根据userId查看个人能力档案*/
    List<Ablity_file> listAbilityFileByStudentId(@Param("studentId")BigInteger studentId);

    /*根据courseId查看个人能力档案*/
    List<Ablity_file> listAbilityFileByCourseId(@Param("courseId")BigInteger courseId);
}
