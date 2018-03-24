package xmu.yunzhieducation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.DateMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.TrainingMapper;
=======
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.Ablity_file;
import xmu.yunzhieducation.entity.Class_student;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.DateMapper;
>>>>>>> 811861e0747ebbf7a0c0b923c6674ef0d5eeb3ad
import xmu.yunzhieducation.service.DataService;
import xmu.yunzhieducation.vo.ParticipationVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class DataServiceImpl implements DataService{
<<<<<<< HEAD
    @Autowired
    private DateMapper dateMapper;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private CourseMapper courseMapper;
=======

    @Autowired
    private DateMapper dateMapper;

    @Autowired
    private CourseMapper courseMapper;


>>>>>>> 811861e0747ebbf7a0c0b923c6674ef0d5eeb3ad
    /**
     * 查看学生某门课的成绩
     */
    @Override
    public int getGradeByCourseIDStudentID(BigInteger class_id,BigInteger student_id){
        return dateMapper.listClassStudentByClassIdAndStudentId(class_id,student_id).getGrade();
    }
    /**
     *老师或学校查看某个学生的所有能力档案
     */
    @Override
    public List<Ablity_file> getAbilityfileByStudentID(BigInteger student_id){
        return dateMapper.listAbilityFileByStudentId(student_id);
    }
    /**
     * 查看课程下所有学生的能力档案
     */
    @Override
    public List<Ablity_file> getAbilityfileBycourseID(BigInteger course_id){
        return dateMapper.listAbilityFileByCourseId(course_id);
    }
    /**
     * 查看课程下某个学生的能力档案
     */
    @Override
    public Ablity_file getAbilityfileBycourseIDAndStudentID(BigInteger course_id,BigInteger student_id){
        return dateMapper.listAbilityFileByCourseIdAndStudentId(course_id,student_id);
    }
    /**
     * 根据学生ID和课程ID给某学生添加能力评价
     */
    @Override
    public void insertAbilityfileByStudentID(Ablity_file ablity_file){
        dateMapper.insertAbilityFileByCourseIdAndStudentId(ablity_file);

    }





    /**
     * 老师获取某门课程下某班级的所有学生
     */
    @Override
    public List<User> getAllStudentByClassID(BigInteger class_id){
        List<Class_student> class_students=dateMapper.listClassStudentByClassId(class_id);//现获取全部的class_student
        if(class_students.isEmpty()) return null;
        List<User> users=new ArrayList<User>();
        for(Class_student class_student:class_students)//根据class_student中的studentID来查找所有的学生信息
        {
            User user=loginMapper.selectUserByuserID(class_student.getStudent_id());
            users.add(user);
        }
        return users;
    }
    /**
     *获取某个实训下的参与度分析（包括应参与人数和已参与人数）
     */
<<<<<<< HEAD
    public ParticipationVo trainingparticipationByTrainingID(BigInteger training_id){
        Trainging trainging=trainingMapper.listTrainingByTrainingId(training_id);
        List<Class1> class1s=courseMapper.selectClassByCourseID(trainging.getCourse_id());

=======
    @Override
    public double trainingparticipationByTrainingID(BigInteger training_id){
        return 2;
>>>>>>> 811861e0747ebbf7a0c0b923c6674ef0d5eeb3ad
    }
    /**
     * 获得某个实训下的所有学生的得分
     */
    @Override
    public List<Integer> getAllGradeByTrainingID(BigInteger training_id){
        List<Integer> trainingID=new ArrayList<>();
        return trainingID;
    }
}
