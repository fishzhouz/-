package xmu.yunzhieducation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.User;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void insertUser(User user)
    {
        loginMapper.insertUser(user);
    }

}
