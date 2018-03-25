package xmu.yunzhieducation.service.Impl;

import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.SchoolMapper;
import xmu.yunzhieducation.mapper.CourseMapper;
import xmu.yunzhieducation.service.LoginService;

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
    public List<Course> getAllCourse() {
        List<Course> courses=schoolMapper.listAllCourses();
        List<Course> courses1=new ArrayList<Course>();
        if(courses.isEmpty() )return null;
        for(int i=courses.size()-1,j=0; j<20 && i>=0;j++,i--)//获取20个课程，如果总课程少于20，就全部获取
            courses1.add(courses.get(i));
        return courses1;
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
        if(loginMapper.Login(account,password)!=null)
            return true;//如果密码正确返回true
        else
            return false;//密码错误返回false
    }

    /*新建用户，把user插入，但是account不能重复*/
    @Override
    public boolean insertUser(User user) {
        List<User> users = loginMapper.listAllUsers();
        for (User us : users) {
            if (us.getAccount().equals(user.getAccount()))//若账号重复则返回false
                return false;
        }
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
