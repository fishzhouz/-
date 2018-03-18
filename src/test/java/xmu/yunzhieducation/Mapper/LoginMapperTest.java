package xmu.yunzhieducation.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Message;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.mapper.LoginMapper;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginMapperTest {
    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void testLogin()
    {
        User u=loginMapper.Login("4321","4321");
        System.out.println(u);
    }

    @Test
    public void testUpdateUserInfo()
    {
        User u=new User();
        u.setId(new BigInteger("7"));
        u.setAccount("鱼粥粥");
        u.setPassword("12580");
        u.setIdentified(2);
        u.setName("陈滨");
        u.setNumber("24320152202718");
        u.setSchool_id(new BigInteger("1"));
        u.setSex(0);
        u.setIntroduction("这个很懒，什么都没有留下");
        loginMapper.updateUserInfo(u);
    }

    @Test
    public void testListAllMessage()
    {
        List<Message> messages=loginMapper.listAllMessage(new BigInteger("3"));
        for(Message m:messages)
        {
            System.out.println(m);
        }
    }

    @Test
    public void testUpdateMessage()
    {
        loginMapper.updateMessage(new BigInteger("3"));
    }

    @Test
    public void testInsertMessage()
    {
        Message m=new Message();
        m.setUser_id(new BigInteger("3"));
        m.setType(0);
        m.setContent("你的话题被回复啦");
        m.setTime(new Date(118,2,2,2,12,34));
        m.setIs_read(0);
        m.setTopic_id(new BigInteger("1"));
        loginMapper.insertMessage(m);
    }

    @Test
    public void testDeleteMessageByID()
    {
        loginMapper.deleteMessageByID(new BigInteger("4"));
    }
}
