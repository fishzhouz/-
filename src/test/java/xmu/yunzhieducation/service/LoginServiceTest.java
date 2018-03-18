package xmu.yunzhieducation.service;

import org.assertj.core.error.ShouldBeInSameYear;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.service.Impl.LoginServiceImpl;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @Test
    public void testInsertUser()
    {
        try
        {
            User u=new User();
            u.setAccount("abc");
            u.setPassword("123");
            u.setIdentified(0);
            u.setName("陈滨");
            u.setSchool_id(new BigInteger("2"));
            u.setNumber("24320152202718");
            u.setSex(0);
            u.setIntroduction("这个人很懒，什么都没有留下");
            System.out.print(u.getId());
            loginServiceImpl.insertUser(u);
        }
        catch (Exception e)
        {

        }
    }
}
