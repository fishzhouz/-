package xmu.yunzhieducation.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.BigIntegerTypeHandler;
import org.springframework.stereotype.Component;
import sun.nio.cs.US_ASCII;
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
    User  Login(@Param("account") String account,@Param("password") String password);
    /**
     *修改个人信息，包括密码
     */
    void  updateUserInfo(User user);
    /**
     *查看消息列表
     */
    List<Message>  listAllMessage(@Param("user_id") BigInteger user_id);
    /**
     *点击消息修改状态
     */
    void updateMessage(@Param("message_id") BigInteger message_id);
    /**
     * 当课程不存在时或话题被回复时增加消息
     */
    void insertMessage(Message message);
    /**
     * 用户可以删除已读消息
     */
    void deleteMessageByID(@Param("message_id") BigInteger message_id);
    /**
     * 查看用户个人信息
     */
    User selectUserByuserID(@Param("id") BigInteger id);
    /**
     * 获取全部的user，目的是注册用户时account不能相同
     */
    List<User> listAllUsers();
    /**
     * 根据topic_id获取
     */
    List<Message> listMessageByTopicId(@Param("topic_id")BigInteger topic_id);

}
