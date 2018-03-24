package xmu.yunzhieducation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.DateMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.TrainingMapper;
import xmu.yunzhieducation.service.DataService;
import xmu.yunzhieducation.vo.ParticipationVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class DataServiceImpl implements DataService{
    @Autowired
    private DateMapper dateMapper;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private CourseMapper courseMapper;
    /**
     * 查看学生某门课的成绩
     */
    @Override
    public int getGradeByCourseIDStudentID(BigInteger course_id,BigInteger student_id){
        return 1;
    }
    /**
     *老师或学校查看某个学生的能力档案
     */
    public List<Ablity_file> getAbilityfileByStudentID(BigInteger student_id){
        List<Ablity_file> ablity_files=new ArrayList<>();
        return ablity_files;
    }
    /**
     * 学生查看自己的能力档案
     */
    public List<Ablity_file> getownAbilityfileByStudentID(BigInteger student_id){
        List<Ablity_file> ablity_files=new ArrayList<>();
        return ablity_files;
    }
    /**
     * 根据学生ID和课程ID给某学生添加能力评价
     */
    public void insertAbilityfileByStudentID(BigInteger student_id, BigInteger course_id){

    }
    /**
     * 老师获取某门课程下某班级的所有学生
     */
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
    public ParticipationVo trainingparticipationByTrainingID(BigInteger training_id){
        Trainging trainging=trainingMapper.listTrainingByTrainingId(training_id);
        List<Class1> class1s=courseMapper.selectClassByCourseID(trainging.getCourse_id());

    }
    /**
     * 获得某个实训下的所有学生的得分
     */
    public List<Integer> getAllGradeByTrainingID(BigInteger training_id){
        List<Integer> trainingID=new ArrayList<>();
        return trainingID;
    }
}
