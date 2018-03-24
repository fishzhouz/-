package xmu.yunzhieducation.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.service.Impl.CourseServiceImpl;
import xmu.yunzhieducation.vo.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/student",method = RequestMethod.GET)
    @ResponseBody
    public List<CourseAndTeacherVo> getOwnCourse(@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.getOwnCourse(user_id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/teacher",method = RequestMethod.GET)
    @ResponseBody
    public List<CourseVo> getTeacherCourse(@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.getTeacherCourse(user_id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{course_id}",method = RequestMethod.GET)
    @ResponseBody
    public CourseInfoVo getCourseInfo(@RequestParam(value="user_id") BigInteger user_id, @PathVariable("course_id") BigInteger course_id)
    {
        return courseServiceImpl.getCourseInfo(user_id,course_id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{class_id}/period",method = RequestMethod.GET)
    @ResponseBody
    public List<PeriodInfoVo> getOwnPeriod(@PathVariable("class_id") BigInteger class_id,@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.getOwnPeriod(class_id,user_id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{class_id}/task",method = RequestMethod.GET)
    @ResponseBody
    public List<TaskVo> getOwnTask(@PathVariable("class_id") BigInteger class_id)
    {
        return courseServiceImpl.getOwnTask(class_id);
    }
    //还未测试
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/course/{class_id}/choose",method = RequestMethod.POST)
    @ResponseBody
    public boolean chooseCourse(@PathVariable("class_id") BigInteger class_id,@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.chooseCourse(user_id, class_id);
    }
}
