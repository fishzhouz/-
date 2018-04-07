package xmu.yunzhieducation.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.Class_student;
import xmu.yunzhieducation.entity.Comment;
import xmu.yunzhieducation.entity.Course;
import xmu.yunzhieducation.entity.Topic;
import xmu.yunzhieducation.entity.Message;
import xmu.yunzhieducation.mapper.CommentMapper;

import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.service.CommentService;
import xmu.yunzhieducation.service.CourseService;
import xmu.yunzhieducation.vo.CommentVo;

import java.math.BigInteger;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private LoginMapper loginMapper;

    @Override

    /**
     * 获取某门课程或者学校下的帖子
     */
    public List<Topic> ListAllTopicByBelongingId(int type, BigInteger course_id) {
        List<Topic> topicList;
        topicList=commentMapper.selectTopicBybelongingID(course_id,type);
        return topicList;
    }

    /**
     * 发表话题
     */
    public Boolean InsertTopic(Topic topic){
        commentMapper.insertTopicByID(topic);
        return true;
    }

    /**
     *对某个话题进行评论
     **/
    public Boolean InsertCommentByBelongingId(Comment comment){
        commentMapper.insertCommentByID(comment);
        return true;
    }
    /**
     * 查看话题下的所有评论
     */
    public List<CommentVo> ListAllCommentByTopicId(BigInteger topic_id){
        List<CommentVo> commentVos=new ArrayList<>();
        List<Comment> commentList;
        commentList=commentMapper.selectCommentBytopicID(topic_id);
        for(Comment c:commentList)
        {
            CommentVo commentVo=new CommentVo();
            commentVo.setComment(c);
            commentVo.setName(loginMapper.selectUserByuserID(c.getUser_id()).getName());
            commentVos.add(commentVo);
        }
        return commentVos;
    }

    /**
     * 查看用户的全部评论
     */
    public List<CommentVo> ListAllCommentByUserId(BigInteger user_id){
        List<CommentVo> commentVos=new ArrayList<>();
        List<Comment> commentList;
        commentList=commentMapper.selectCommentByuserID(user_id);
        for(Comment c:commentList)
        {
            CommentVo commentVo=new CommentVo();
            commentVo.setComment(c);
            commentVo.setName(loginMapper.selectUserByuserID(user_id).getName());
            commentVos.add(commentVo);
        }
        return commentVos;
    }

    /**
     * 查看用户的所有话题
     */
    public List<Topic> ListAllTopicByUserId(BigInteger user_id){
        List<Topic> topicList;
        topicList=commentMapper.selectTopicByuserID(user_id);
        return topicList;
    }

    /**
     *查看用户某个话题下的所有评论
     */
    public List<CommentVo> ListAllCommentByTopicIdAndMe(BigInteger user_id,BigInteger topic_id){
        List<CommentVo> commentVos=new ArrayList<>();
        List<Comment> commentList;
        commentList=commentMapper.selectCommentBytopicIDAnduserID(topic_id,user_id);
        for(Comment c:commentList)
        {
            CommentVo commentVo=new CommentVo();
            commentVo.setComment(c);
            commentVo.setName(loginMapper.selectUserByuserID(user_id).getName());
            commentVos.add(commentVo);
        }
        return commentVos;
    }

    /**
     * 删除所选评论
     */
    public Boolean DeleteCommentById(BigInteger comment_id){
        commentMapper.deleteCommentByID(comment_id);
        return true;
    }

    /**
     * 删除所选话题
     */
    public Boolean DeleteTopicById(BigInteger topic_id){
        //获取当前话题下的所有评论。删除评论后删除话题
        List<Comment> commentList=commentMapper.selectCommentBytopicID(topic_id);
        for (Comment i:commentList) {
            commentMapper.deleteCommentByID(i.getId());
        }
        List<Message> messageList=loginMapper.listMessageByTopicId(topic_id);
        for(Message msg:messageList){
            loginMapper.deleteMessageByID(msg.getId());
        }
        commentMapper.deleteTopicByID(topic_id);
        return true;
    }
}