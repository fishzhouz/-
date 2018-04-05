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
import xmu.yunzhieducation.vo.CourseVo;

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
    public List<CourseVo> getCourseBySchoolID(BigInteger school_id) {
        List<CourseVo> courseVos=new ArrayList<>();
        List<User> teachers=schoolMapper.listTeacherBySchoolId(school_id);
        List<Course> courses=new ArrayList<Course>();
        if(teachers.isEmpty()) return null;
        for(User teacher:teachers) {    //遍历该校所有老师
            List<Course> courses1 = courseMapper.selectCourseByTeacherID(teacher.getId());  //把老师下的课程选择出来
            for(Course c:courses1) {
                CourseVo courseVo=new CourseVo();
                courseVo.setTeacher_name(teacher.getName());
                courseVo.setPicture(c.getPicture());
                courseVo.setCourse_name(c.getName());
                courseVo.setCourse_id(c.getId());
                courseVos.add(courseVo);
            }
        }
        return courseVos;
    }

    @Override
    public List<User> getTeacherBySchoolID(BigInteger school_id){
        List<User> teachers=schoolMapper.listTeacherBySchoolId(school_id);
        if(teachers.isEmpty()) return null;
        return teachers;
    }
     /*
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
    */
    @Override
    public List<School_information> getSchoolInformationBySchoolID(BigInteger school_id){
        //List<School_information> school_informations=schoolMapper.selectCourseImgByschoolID(school_id);//得到轮播图
        List<School_information> school_informations1=schoolMapper.selectInfoByschoolID(school_id);//得到学校的资讯
        return school_informations1;
    }
    /*根据资讯（或轮播图）的ID删除这条资讯（或轮播图）*/
    @Override
    public void deleteSchoolInformationByInformationID(BigInteger infromation_id){
        schoolMapper.deleteSchoolInfo(infromation_id);
    }

    /*插入学校资讯*/
    @Override
    public void insertInformationBySchoolID(School_information school_information){
        schoolMapper.insertSchoolInfo(school_information);
    }

    /*更新学校信息*/
    @Override
    public void updateSchoolBySchoolID(School school){
        schoolMapper.updateSchool(school);
    }

    @Override
    public School getSchool(BigInteger school_id){
        return schoolMapper.selectSchoolById(school_id);
    }
}
