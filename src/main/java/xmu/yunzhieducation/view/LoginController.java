package xmu.yunzhieducation.view;

import com.sun.org.apache.xerces.internal.util.HTTPInputSource;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.entity.Message;
import xmu.yunzhieducation.entity.School;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.service.Impl.LoginServiceImpl;
import xmu.yunzhieducation.vo.CourseVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginServiceImpl;
    @Autowired
    private LoginMapper loginMapper;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login/course",method = RequestMethod.GET)
    @ResponseBody
    public List<CourseVo> getAllCourse(){
        return loginServiceImpl.getAllCourse();

    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login/school",method = RequestMethod.GET)
    @ResponseBody
    public List<School> getAllSchool(){
        return loginServiceImpl.getAllSchool();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login/schools",method = RequestMethod.GET)
    @ResponseBody
    public List<School> getSchools(@RequestParam(value = "province") String province){
       List<School> schools=loginServiceImpl.getAllSchool();
       List<School> schoolList=new ArrayList<>();
       for(School s:schools){
           if(s.getProvince().equals(province)){
               schoolList.add(s);
           }
       }
       return schoolList;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login/schools2",method = RequestMethod.GET)
    @ResponseBody
    public BigInteger getSchools2(@RequestParam(value = "name") String name){
        List<School> schools=loginServiceImpl.getAllSchool();
        for(School s:schools){
            if(s.getName().equals(name)){
                 return s.getId();
            }
        }
        return null;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestParam(value = "account")String account, @RequestParam(value = "password") String password)
    {
      return loginServiceImpl.login(account,password);

    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    public User getuser(@RequestParam(value = "account")String account, @RequestParam(value = "password") String password)
    {
        return loginServiceImpl.getuser(account,password);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login/judge",method = RequestMethod.GET)
    @ResponseBody
    public boolean accountnot(@RequestParam(value = "account")String account)
    {
        return loginServiceImpl.accountNot(account);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertUser(@RequestBody User user){
        return loginServiceImpl.insertUser(user);
    }



    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/me/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo(@PathVariable ( "user_id")BigInteger user_id)
    {
        return loginServiceImpl.getUserInformation(user_id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/me",method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateUserInfo(@RequestBody User user){
        return loginServiceImpl.updateUser(user);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/me/message/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getAllMessage(@PathVariable("user_id")BigInteger user_id)
    {
        return loginServiceImpl.getAllMessage(user_id);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/me/message/{message_id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateMessage(@PathVariable("message_id")BigInteger message_id){ loginMapper.updateMessage(message_id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/me/message/{message_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteMessage(@PathVariable("message_id")BigInteger message_id){
        loginMapper.deleteMessageByID(message_id);
    }
}
