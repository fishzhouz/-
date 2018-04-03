package xmu.yunzhieducation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.School;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.entity.Message;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.mapper.SchoolMapper;
import xmu.yunzhieducation.vo.CourseVo;

import java.math.BigInteger;
import java.util.List;

@Component
public interface LoginService {
    /**
     * 获取平台入口展示的20个课程
     */
    public List<CourseVo> getAllCourse();
    /**
     * 获取平台入口展示的20个学校
     */
    public List<School> getAllSchool();
    /**
     * 用户登录,密码正确返回1，密码错误返回0
     */
    public boolean login(String account,String password);
    public User getuser(String account,String password);
    /**
     * 注册用户,account重复时，插入失败，返回false，否则插入成功
     */
    public boolean insertUser(User user);
    public boolean accountNot(String account);
    /**
     * 获取用户的所有个人信息
     */
    public User getUserInformation(BigInteger user_id);
    /**
     * 修改用户的信息
     */
    public boolean updateUser(User user);
    /**
     *获取当前用户所有message
     */
    public List<Message> getAllMessage(BigInteger user_id);
}
