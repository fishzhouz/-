package xmu.yunzhieducation.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.SchoolMapper;
import xmu.yunzhieducation.service.CourseService;
import xmu.yunzhieducation.service.SchoolService;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private SchoolMapper schoolMapper;

    /*根据学校ID获得全部老师，然后根据老师ID获得全部的课程，返回该学校的所有课程*/
    @Override
    public List<Course> getCourseBySchoolID(BigInteger school_id) {
        List<User> teachers=schoolMapper.listTeacherBySchoolId(school_id);
        List<Course> courses=new ArrayList<Course>();
        if(teachers.isEmpty()) return null;
        for(User teacher:teachers) {    //遍历该校所有老师
            List<Course> courses1 = courseMapper.selectCourseByTeacherID(teacher.getId());  //把老师下的课程选择出来
            courses.addAll(courses1);
        }
        return courses;
    }

    @Override
    public List<User> getTeacherBySchoolID(BigInteger school_id){
        List<User> teachers=schoolMapper.listTeacherBySchoolId(school_id);
        if(teachers.isEmpty()) return null;
        return teachers;
    }

    @Override
    public List<String> getSchoolInformationBySchoolID(BigInteger school_id){
        List<School_information> school_informations=schoolMapper.selectInfoByschoolID(school_id);//得到学校的资讯
        if(school_informations.isEmpty()) return null;
        List<String> strings=new ArrayList<String>();
        for(School_information school_information:school_informations){
            strings.add(school_information.getContent());
        }
        return strings;
    }

    @Override
    public List<String> getSchoolPictureBySchoolID(BigInteger school_id){
        List<School_information> school_informations=schoolMapper.selectCourseImgByschoolID(school_id);//得到轮播图的路径
        if(school_informations.isEmpty()) return null;
        List<String> strings=new ArrayList<String>();
        for(School_information school_information:school_informations)
        {
            strings.add(school_information.getContent());
        }
        return strings;
    }
    /*根据资讯（或轮播图）的ID删除这条资讯（或轮播图）*/
    @Override
    public void deleteSchoolInformationByInformationID(BigInteger infromation_id){
        schoolMapper.deleteSchoolInfo(infromation_id);
    }

    @Override
    public void insertMessageBySchoolID(School_information school_information){
        schoolMapper.insertSchoolInfo(school_information);
    }
    @Override
    public void updateSchoolBySchoolID(School school){
        schoolMapper.updateSchool(school);
    }

    @Override
    public School getSchool(BigInteger school_id){
        return schoolMapper.selectSchoolById(school_id);
    }
}
