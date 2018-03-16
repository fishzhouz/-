package xmu.yunzhieducation.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Student_training;
import xmu.yunzhieducation.entity.Trainging;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface TrainingMapper {

    /*发布实训，根据courseId插入新的实训*/
    Boolean insertTraining(Trainging trainging);


    /*根据课程id找到课程下的所有实训*/
    List<Trainging> listTrainingByCourseId(@Param("courseId")BigInteger courseId);


    /*根据实训id找到具体的实训*/
    Trainging listTrainingByTrainingId(@Param("trainingId")BigInteger trainingId);


    /*学生选择实训，并将记录插入数据库中的学生实训表*/
    Boolean insertStudentTraining(Student_training studentTraining);


    /*上传学生在某个实训时的实训报告*/
    Boolean updateStudentTrainingReportByStudentIdAndTrainingId(Student_training studentTraining);


    /*老师为学生的实训效果打分，上传分数*/
    Boolean updateStudentTrainingScoreByStudentIdAndTrainingId(Student_training studentTraining);


    /*根据学生id和实训id找到学生在实训里的具体情况，可查看自己的报告和自己的实训成绩*/
    Student_training listStudentTrainingByStudentIdAndTeacherId(@Param("studentId")BigInteger stuentId,@Param("teacherId")Boolean teacherId);


    /*根据实训id找到实训下的所有学生的报告和成绩*/
    Student_training listStudentTrainingByTeacherId(@Param("teacherId")BigInteger teacherId);
}
