package xmu.yunzhieducation.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.BigIntegerTypeHandler;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Message;
import xmu.yunzhieducation.entity.User;

import java.math.BigInteger;
import java.util.List;


/**
 * School Mapper
 * 注意，每个mapper要给其加上一个@Mapper的注解。
 * 且每个mapper都是接口，实现是由mybatis做的,不需要我们实现。
 */
@Mapper
@Component
public interface LoginMapper {
    /**
     *注册用户
     */
    void  insertUser(User user);
    /**
     *登陆用户
     */
    boolean  Login(@Param("account") String account,@Param("password") String password);
    /**
     *修改个人信息，包括密码
     */
    boolean  updateUserInfo(User user);
    /**
     *查看消息列表
     */
    List<Message>  listAllMessage(@Param("user_id") BigInteger user_id);
    /**
     *点击消息修改状态
     */
    boolean updateMessage(@Param("message_id") BigInteger message_id,@Param("index") int index);
}
