package xmu.yunzhieducation.service;


import xmu.yunzhieducation.entity.*;

import java.math.BigInteger;
import java.util.List;

public interface SchoolService {
    /**
     * 根据学校ID获取全部的课程
     */
    public List<Course> getCourseBySchoolID(BigInteger school_id);
    /**
     * 根据学校ID获取全部的老师
     */
    public List<User> getTeacherBySchoolID(BigInteger school_id);
    /**
     * 根据学校ID获取资讯信息
     */
    public List<String> getSchoolInformationBySchoolID(BigInteger school_id);
    /**
     * 根据学校ID获取轮播图(路径）
     */
    public List<School_information> getSchoolPictureBySchoolID(BigInteger school_id);
    /**
     * 根据资讯ID删除资讯
     */
    public void deleteSchoolInformationByInformationID(BigInteger infromation_id);
    /**
     * 根据学校ID上传资讯
     */
    public void insertMessageBySchoolID(School_information school_information);
    /**
     * 修改学校信息
     */
    public void updateSchoolBySchoolID(School school);
    /**
     * 查看学校信息
     */
    public School getSchool(BigInteger school_id);
}
