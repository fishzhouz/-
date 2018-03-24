package xmu.yunzhieducation.service.Impl;

import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.Ablity_file;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.service.DataService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class DataServiceImpl implements DataService{

    



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
    @Override
    public List<Ablity_file> getAbilityfileByStudentID(BigInteger student_id){
        List<Ablity_file> ablity_files=new ArrayList<>();
        return ablity_files;
    }
    /**
     * 学生查看自己的能力档案
     */
    @Override
    public List<Ablity_file> getownAbilityfileByStudentID(BigInteger student_id){
        List<Ablity_file> ablity_files=new ArrayList<>();
        return ablity_files;
    }
    /**
     * 根据学生ID和课程ID给某学生添加能力评价
     */
    @Override
    public void insertAbilityfileByStudentID(BigInteger student_id, BigInteger course_id){

    }
    /**
     * 老师获取某门课程下某班级的所有学生
     */
    @Override
    public List<User> getAllStudentByClassID(BigInteger class_id){
        List<User> users=new ArrayList<>();
        return users;
    }
    /**
     *获取某个实训下的参与度分析（包括应参与人数和已参与人数）
     */
    @Override
    public double trainingparticipationByTrainingID(BigInteger training_id){
        return 2;
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
