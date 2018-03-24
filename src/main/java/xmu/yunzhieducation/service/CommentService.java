package xmu.yunzhieducation.service;
import org.springframework.stereotype.Component;
import xmu.yunzhieducation.vo.CourseAndTeacherVo;
import java.math.BigInteger;
import java.util.List;
import xmu.yunzhieducation.entity.Topic;
import xmu.yunzhieducation.entity.Comment;

@Component
public interface CommentService {

    /**
     Authorized By JL
     */

    /**
     * 获取某门课程或者学校下的帖子
     */
    public List<Topic> ListAllTopicByBelongingId(int type,BigInteger course_id);

    /**
     * 发表话题
     */
    public Boolean InsertTopic(Topic topic);

    /**
     *对某个话题进行评论
     **/
    public Boolean InsertCommentByBelongingId(Comment comment);

    /**
     * 查看话题下的所有评论
     */
    public List<Comment> ListAllCommentByTopicId(BigInteger topic_id);

    /**
     * 查看用户的全部评论
     */
    public List<Comment> ListAllCommentByUserId(BigInteger user_id);

    /**
     * 查看用户的所有话题
     */
    public List<Topic> ListAllTopicByUserId(BigInteger user_id);

    /**
     * 删除所选评论
     */
    public Boolean DeleteCommentById(BigInteger comment_id);

    /**
     * 删除所选话题
     */
    public Boolean DeleteTopicById(BigInteger topic_id);

}