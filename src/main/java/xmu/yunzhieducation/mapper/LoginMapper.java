package xmu.yunzhieducation.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.User;

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
}
