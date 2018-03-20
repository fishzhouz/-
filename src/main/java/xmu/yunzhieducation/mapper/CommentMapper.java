package xmu.yunzhieducation.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.entity.Comment;
import xmu.yunzhieducation.entity.Topic;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface CommentMapper {
    /**
     * 新增话题
     */
    void insertTopicByID(Topic topic);
    /**
     * 删除话题
     */
    void deleteTopicByID(@Param("topic_id") BigInteger topic_id);
    /**
     * 话题中新增评论
     */
    void insertCommentByID(Comment comment);
    /**
     * 删除评论
     */
    void deleteCommentByID(@Param("comment_id") BigInteger comment_id);
    /**
     * 根据ID选话题
     */
    List<Topic> selectTopicBybelongingID(@Param("belonging_id") BigInteger belonging_id,@Param("type") Integer type);
    /**
     * 找话题的全部评论
     */
    List<Comment> selectCommentBytopicID(@Param("topic_id") BigInteger topic_id);
    /**
     * 根据用户找话题
     */
    List<Topic> selectTopicByuserID(@Param("user_id") BigInteger user_id);
    /**
     * 根据用户找评论
     */
    List<Comment> selectCommentByuserID(@Param("user_id") BigInteger user_id);
    /**
     * 根据评论找话题id
     */
    BigInteger selectTopicBycommentID(@Param("comment_id") BigInteger comment_id);
    /**
     * 寻找当前话题下用户的全部评论
     */
    List<Comment> selectCommentBytopicIDAnduserID(@Param("topic_id") BigInteger topic_id,@Param("user_id") BigInteger user_id);
}
