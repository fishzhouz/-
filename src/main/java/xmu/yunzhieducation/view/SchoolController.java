package xmu.yunzhieducation.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.entity.School;
import xmu.yunzhieducation.entity.School_information;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.service.Impl.SchoolServiceImpl;

import javax.jws.soap.SOAPBinding;
import java.math.BigInteger;
import java.security.PublicKey;
import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolServiceImpl schoolServiceImpl;

    /*获得学校下的所有课程*/
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/school/{school_id}/course",method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getCourseBySchoolID(@PathVariable ("school_id")BigInteger school_id) {
        return schoolServiceImpl.getCourseBySchoolID(school_id);
    }

    /*获得学校下的所有老师*/
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/school/{school_id}/teacher",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getTeacherBySchoolID(@PathVariable ("school_id") BigInteger school_id){
        return schoolServiceImpl.getTeacherBySchoolID(school_id);
    }

    /*获得学校资讯以及轮播图*/
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/school/{school_id}/information",method = RequestMethod.GET)
    @ResponseBody
    public List<School_information> getInformationBySchoolID(@PathVariable("school_id")BigInteger school_id){
        return schoolServiceImpl.getSchoolInformationBySchoolID(school_id);
    }

    /*删除某条资讯*/
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/school/{school_information_id}/information",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteSchoolInformationByID(@PathVariable("school_information_id")BigInteger school_information_id){
        schoolServiceImpl.deleteSchoolInformationByInformationID(school_information_id);
        return true;
    }

    /*按照学校ID上传资讯*/
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/school/{school_id}/information",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertSchoolInformation(@PathVariable("school_id")BigInteger school_id,@RequestBody School_information school_information){
        school_information.setSchool_id(school_id);
        schoolServiceImpl.insertInformationBySchoolID(school_information);
        return true;
    }

    /*修改学校信息*/
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "school/{school_id}",method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateSchool(@PathVariable("school_id")BigInteger school_id, @RequestBody School school){
        schoolServiceImpl.updateSchoolBySchoolID(school);
        return true;
    }

    /*查看学校信息*/
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "school/{school_id}",method = RequestMethod.GET)
    @ResponseBody
    public School getSchool(@PathVariable("school_id")BigInteger school_id){
        return schoolServiceImpl.getSchool(school_id);
    }
}
