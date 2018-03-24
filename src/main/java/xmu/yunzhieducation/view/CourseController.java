package xmu.yunzhieducation.view;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.service.Impl.CourseServiceImpl;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course",method = RequestMethod.GET)
    @ResponseBody
    public List<CourseAndTeacherVo> getOwnCourse(@RequestParam(value = "user_id",required = false) BigInteger user_id,@RequestParam(value = "user_id",required = false) Integer type)
    {
        return courseServiceImpl.getOwnCourse(user_id,type);
    }
}
