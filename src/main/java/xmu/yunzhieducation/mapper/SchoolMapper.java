package xmu.yunzhieducation.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.*;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * School Mapper
 * 注意，每个mapper要给其加上一个@Mapper的注解。
 * 且每个mapper都是接口，实现是由mybatis做的,不需要我们实现。
 */
@Mapper
@Component
public interface SchoolMapper {
    /**
    *添加学校
     */
    void  insertSchool(School school);
    /**
    *修改学校信息
     */
    void  updateSchool(School school);
    /**
    *新增学校资讯，包括轮播图和公告
     */
    void  insertSchoolInfo(School_information school_information);
    /**
    *删除学校资讯
     */
    void  deleteSchoolInfo(@Param("id") BigInteger id);
    /**
    *修改学校资讯
     */
    void  updateSchoolInfo(@Param("info") String info,@Param("id") BigInteger id);
    /**
    *删除教师
     */
    void  deleteTeacher(@Param("teacher_id") BigInteger teacher_id);
    /**
    *为课程新增班级
     */
    void  insertClass(Class1 class1);
    /**
    *删除课程下的班级
     */
    void  deleteClass(@Param("class_id") BigInteger class_id);
    /**
    *修改班级信息
     */
    void  updateClassInfo(Class1 class1);
    /**
    *查看学校下的所有教师
     */
    List<User> listTeacherBySchoolId(@Param("school_id") BigInteger school_id);
    /**
    *显示所有学校
     */
    List<School>  listAllSchools();
    /**
    *显示所有课程
     */
    List<Course>  listAllCourses();
    /**
     * 根据学校ID学学校
     */
    School selectSchoolById(@Param("id") BigInteger id);
    /**
     * 选出某个学校的全部资讯
     */
    List<School_information> selectInfoByschoolID(@Param("school_id") BigInteger school_id);
    /**
     * 选出某个学校的全部课程轮播图
     */
    List<School_information> selectCourseImgByschoolID(@Param("school_id") BigInteger school_id);
}
