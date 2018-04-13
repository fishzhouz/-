package xmu.yunzhieducation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.DateMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.TrainingMapper;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.Ablity_file;
import xmu.yunzhieducation.entity.Class_student;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.DateMapper;
import xmu.yunzhieducation.service.DataService;
import xmu.yunzhieducation.vo.ParticipationVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
    public int getGradeByCourseIDStudentID(BigInteger class_id,BigInteger student_id){
          if(dateMapper.listClassStudentByClassIdAndStudentId(class_id,student_id).getGrade()==null)
              return -1;
          else
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
    @Override
    public ParticipationVo trainingparticipationByTrainingID(BigInteger training_id){
        ParticipationVo participationVo=new ParticipationVo();
        Trainging trainging=trainingMapper.listTrainingByTrainingId(training_id);
        List<Class1> class1s=courseMapper.selectClassByCourseID(trainging.getCourse_id());
        Date date=new Date();
        Class1 class1=new Class1();
        for(Class1 class2:class1s)
        {
            if(date.compareTo(class2.getStart_time())>=0&&date.compareTo(class2.getEnd_time())<0)
            {
                class1=class2;
                break;
            }
        }
        participationVo.setSelected_num(trainging.getStudent_num());
        participationVo.setAll_student_num(class1.getStudent_num());
        return participationVo;
    }
    /**
     * 获得某个实训下的所有学生的得分
     */
    @Override
    public List<Student_training> getAllGradeByTrainingID(BigInteger training_id){
        return trainingMapper.listStudentTrainingByTrainingId(training_id);
    }

}
