
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
    public List<Trainging> GetTrainingByUserId(BigInteger user_id) {
        List<Class_student> classList=courseMapper.selectClassstudentByStudentID(user_id);
        List<BigInteger> class_idlist=null;
        for (Class_student cs:classList
                ) {
            class_idlist.add(cs.getClass_id());
        }
        List<Trainging> traingingList=null;
        for (BigInteger i:class_idlist) {
            for (BigInteger j:class_idlist
                    ) {
                BigInteger k = courseMapper.selectCourseIDByClassID(j).getCourse_id();
                for (Trainging t:trainingMapper.listTrainingByCourseId(k)
                        ) {
                    traingingList.add(t);
                }
            }
        }
        return traingingList;
    }

    @Override
    public Trainging GetTrainingByTrainingId(BigInteger training_id) {
        Trainging train=trainingMapper.listTrainingByTrainingId(training_id);
        return train;
    }

    @Override
    public Boolean UploadTrainingReport(Student_training st) {
        trainingMapper.insertStudentTraining(st);
        if(trainingMapper.listStudentTrainingByStudentIdAndTrainingId(st.getStudent_id()
                ,st.gettraining_id()).equals(st))
            return true;
        else return false;
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
        if(trainingMapper.listTrainingByTrainingId(train.getId()).equals(train))
            return true;
        else return false;
    }
}
