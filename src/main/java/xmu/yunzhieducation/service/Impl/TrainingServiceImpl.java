
package xmu.yunzhieducation.service.Impl;
/**
 * Created by fengjinliu on 2018/3/24.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.TrainingMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.CourseMapper;

import xmu.yunzhieducation.service.TrainingService;
import xmu.yunzhieducation.vo.TraingingVo;

import java.math.BigInteger;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService{
    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Trainging> GetTrainingByCourseId(BigInteger course_id) {
        return trainingMapper.listTrainingByCourseId(course_id);
    }

    @Override
    public TraingingVo GetTrainingByTrainingId(BigInteger training_id,BigInteger user_id) {
        TraingingVo traingingVo=new TraingingVo();
        Trainging train=trainingMapper.listTrainingByTrainingId(training_id);
        traingingVo.setTrainging(train);
        Student_training student_training=trainingMapper.listStudentTrainingByStudentIdAndTrainingId(user_id,training_id);
        if(student_training==null)
            traingingVo.setIs_upload(false);
        else
            traingingVo.setIs_upload(true);
        return traingingVo;
    }

    @Override
    public Boolean UploadTrainingReport(Student_training st) {
        trainingMapper.insertStudentTraining(st);
        trainingMapper.updateTraining(st.gettraining_id());
            return true;
    }

    @Override
    public Boolean UpdateTrainingReport(Student_training st) {
        trainingMapper.updateStudentTrainingScoreByStudentIdAndTrainingId(st);
        if(trainingMapper.listStudentTrainingByStudentIdAndTrainingId(st.getStudent_id(),
                st.gettraining_id()).getScore()==st.getScore())
            return true;
        else return false;
    }

    @Override
    public Student_training GetTraingingReport(BigInteger student_id,BigInteger training_id) {
        return trainingMapper.listStudentTrainingByStudentIdAndTrainingId(student_id,training_id);

    }

    @Override
    public Boolean InsertTraining(Trainging train) {
        trainingMapper.insertTraining(train);
        return true;
    }
}
