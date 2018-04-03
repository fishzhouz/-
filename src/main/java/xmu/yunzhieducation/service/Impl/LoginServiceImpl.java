package xmu.yunzhieducation.service.Impl;

import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.SchoolMapper;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.service.LoginService;
import xmu.yunzhieducation.vo.CourseVo;

import javax.jws.soap.SOAPBinding;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private SchoolMapper schoolMapper;
    @Autowired
    private CourseMapper courseMapper;
    /*获取页面展示的20个ID最大的课程*/
    @Override
    public List<CourseVo> getAllCourse() {
        List<Course> courses=schoolMapper.listAllCourses();
        List<CourseVo> courses1=new ArrayList<CourseVo>();
        if(courses.isEmpty() )return null;
        for(Course c:courses){
            CourseVo courseVo=new CourseVo();
            courseVo.setCourse_id(c.getId());
            courseVo.setCourse_name(c.getName());
            courseVo.setPicture(c.getPicture());
            courseVo.setTeacher_name(loginMapper.selectUserByuserID(c.getTeacher_id()).getName());
            courses1.add(courseVo);
        }
        List<CourseVo> courseVos=new ArrayList<>();
        for(int i=courses1.size()-1;i>=0;i--)//获取20个学校，如果总学校少于20，就全部获取
            courseVos.add(courses1.get(i));
        return courseVos;
    }

    /*获取页面展示的20个ID最大的学校*/
    @Override
    public List<School> getAllSchool() {
        List<School> schools=schoolMapper.listAllSchools();
        List<School> schools1=new ArrayList<School>();
        if(schools.isEmpty()) return null;
        for(int i=schools.size()-1,j=0; j<20 && i>=0; j++,i--)//获取20个学校，如果总学校少于20，就全部获取
            schools1.add(schools.get(i));
        return schools1;
    }

    /*登录，账号密码成功匹配返回true，否则false*/
    @Override
    public boolean login(String account,String password){
        User u=loginMapper.Login(account,password);
        if(u==null)
        return false;
        else
            return true;
    }
    @Override
    public User getuser(String account,String password){
        return loginMapper.Login(account,password);
    }
    /*登录，账号重复返回false，否则true*/
    @Override
    public boolean accountNot(String account){
        List<User> users = loginMapper.listAllUsers();
        for (User us : users) {
            if (us.getAccount().equals(account))//若账号重复则返回false
                return false;
        }
        return true;
    }

    /*新建用户，把user插入，但是account不能重复*/
    @Override
    public boolean insertUser(User user) {
        loginMapper.insertUser(user);
        return true;
    }

    @Override
    public User getUserInformation(BigInteger user_id){
        return loginMapper.selectUserByuserID(user_id);
    }

    @Override
    public boolean updateUser(User user){
        User user1=loginMapper.selectUserByuserID(user.getId());
        if(user.equals(user1)) return false;
        else {
            loginMapper.updateUserInfo(user);
            return true;
        }
    }

    @Override
    public List<Message> getAllMessage(BigInteger user_id){
        return loginMapper.listAllMessage(user_id);
    }
}
