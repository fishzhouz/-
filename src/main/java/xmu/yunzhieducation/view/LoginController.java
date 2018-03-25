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
import xmu.yunzhieducation.service.Impl.LoginServiceImpl;

import java.math.BigInteger;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login/course",method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getAllCourse(){
        return loginServiceImpl.getAllCourse();

    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login/school",method = RequestMethod.GET)
    @ResponseBody
    public List<School> getAllSchool(){
        return loginServiceImpl.getAllSchool();
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestParam(value = "account")String account, @RequestParam(value = "password") String password)
    {
        return loginServiceImpl.login(account,password);
    }

    @ResponseStatus(value = HttpStatus.OK)
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
}
