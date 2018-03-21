package xmu.yunzhieducation.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;

import java.math.BigInteger;
import java.util.List;

@Component
public interface CourseService {
    /**
     * 获取学生的全部课程（type0)或老师的全部课程（type1）
     */
     List<CourseAndTeacherVo> getOwnCourse(BigInteger user_id,Integer type);
}
