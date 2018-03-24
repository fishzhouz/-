 package xmu.yunzhieducation.service;
 import org.springframework.stereotype.Component;
 import xmu.yunzhieducation.entity.Trainging;
 import xmu.yunzhieducation.entity.Student_training;

 import java.math.BigInteger;
 import java.util.List;

@Component
public interface TrainingService {
    /**
     * 获取当前用户下的所有实训
     */
    public List<Trainging> GetTrainingByUserId(BigInteger user_id);

    /**
     * 查看实训具体内容
     */
    public Trainging GetTrainingByTrainingId(BigInteger training_id);


    /**
     * 上传文件报告
     */
    public Boolean UploadTrainingReport(Student_training st);

    /**
     * 老师给学生报告打分
     */
    public Boolean UpdateTrainingReport(Student_training st);

    /**
     * 学生查看报告具体信息
     */
    public Student_training GetTraingingReport(BigInteger student_id,BigInteger training_id);

    /**
     * 管理员添加实训
     */
    public Boolean InsertTraining(Trainging train);

}