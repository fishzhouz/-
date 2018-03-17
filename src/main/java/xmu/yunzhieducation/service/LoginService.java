package xmu.yunzhieducation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.User;

@Component
public interface LoginService {
    /**
     * 注册用户
     */
    public void insertUser(User user);
}
