package xmu.yunzhieducation.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.entity.Class1;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.entity.Period;
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
    @RequestMapping(value="/course/class/{course_id}",method = RequestMethod.GET)
    @ResponseBody
    public ClassVo getClassInfo(@RequestParam(value="user_id") BigInteger user_id, @PathVariable("course_id") BigInteger course_id)
    {
        return courseServiceImpl.getMyClassInCourse(user_id,course_id);
    }
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{class_id}/period",method = RequestMethod.GET)
    @ResponseBody
    public List<Period> getOwnPeriod(@PathVariable("class_id") BigInteger class_id, @RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.getOwnPeriod(class_id,user_id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{class_id}/task",method = RequestMethod.GET)
    @ResponseBody
    public List<TaskIdAndContentVo> getOwnTask(@PathVariable("class_id") BigInteger class_id,@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.getOwnTask(class_id,user_id);
    }
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/period/{period_id}/task",method = RequestMethod.GET)
    @ResponseBody
    public List<TaskIdAndContentVo> getTask(@PathVariable("period_id") BigInteger period_id,@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.getTask(period_id,user_id);
    }
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{course_id}/error",method = RequestMethod.GET)
    @ResponseBody
    public List<WrongQuestionVo> getOwnWrongQuestion(@PathVariable("course_id") BigInteger course_id,@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.getOwnWrongQuestion(user_id,course_id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/topic1/{type}/{belonging_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<TopicVo> getCircleTopic(@PathVariable("belonging_id") BigInteger belonging_id,@PathVariable("type") Integer type)
    {
        return courseServiceImpl.getCircleTopic(belonging_id,type);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{course_id}/class",method = RequestMethod.GET)
    @ResponseBody
    public List<Class1> getClass(@PathVariable("course_id") BigInteger course_id,@RequestParam(value="type") Integer type )
    {
        return courseServiceImpl.getClass(course_id,type);
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/course/{class_id}/choose",method = RequestMethod.POST)
    @ResponseBody
    public boolean chooseCourse(@PathVariable("class_id") BigInteger class_id,@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.chooseCourse(user_id, class_id);
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/course/{course_id}/class",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertClass(@PathVariable("course_id") BigInteger course_id,@RequestBody Class1 class1)
    {
        return courseServiceImpl.insertClass(class1);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{class_id}/student",method = RequestMethod.GET)
    @ResponseBody
    public List<StudentGradeVo> getStudent(@PathVariable("class_id") BigInteger class_id)
    {
        return courseServiceImpl.getStudent(class_id);
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/course",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertClass(@RequestBody Course course)
    {
        return courseServiceImpl.insertCourse(course);
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{student_id}/{class_id}/grade",method = RequestMethod.PUT)
    @ResponseBody
    public boolean GradeStudent(@PathVariable("class_id") BigInteger class_id,@PathVariable("student_id") BigInteger student_id,@RequestParam(value="grade") Integer grade)
    {
        return courseServiceImpl.GradeStudent(student_id,class_id,grade);
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{class_id}/drop",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean dropCourse(@PathVariable("class_id") BigInteger class_id,@RequestParam(value="user_id") BigInteger user_id)
    {
        return courseServiceImpl.dropCourse(class_id,user_id);
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{course_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteCourse(@PathVariable("course_id") BigInteger course_id)
    {
        return courseServiceImpl.deleteCourse(course_id);
    }
}
