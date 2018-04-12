 package xmu.yunzhieducation.service;
 import org.springframework.stereotype.Component;
 import xmu.yunzhieducation.entity.Trainging;
 import xmu.yunzhieducation.entity.Student_training;
 import xmu.yunzhieducation.vo.TraingingVo;
 import xmu.yunzhieducation.vo.TraingingVo2;

 import java.math.BigInteger;
 import java.util.List;

@Component
public interface TrainingService {
    /**
     * 获取当前课程下的所有实训
     */
    public List<Trainging> GetTrainingByCourseId(BigInteger course_id);

    /**
     * 查看实训具体内容
     */
    public TraingingVo GetTrainingByTrainingId(BigInteger training_id,BigInteger user_id);

    /**
     * 查看实训的消息和学生以及分数
     */
    public TraingingVo2 GetTrainingById(BigInteger training_id);

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