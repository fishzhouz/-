package xmu.yunzhieducation.view;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.mapper.CommentMapper;
import xmu.yunzhieducation.mapper.LoginMapper;
import xmu.yunzhieducation.service.Impl.CommentServiceImpl;

import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.service.Impl.LoginServiceImpl;
import xmu.yunzhieducation.vo.CommentVo;
import xmu.yunzhieducation.vo.TopicVo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentServiceImpl commentServiceImpl;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private LoginMapper loginMapper;

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/topic/{topic_id}",method = RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public List<CommentVo> GetCurrentTopic(@PathVariable("topic_id") BigInteger topic_id)
    {
        return commentServiceImpl.ListAllCommentByTopicId(topic_id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/topic/this/{topic_id}",method = RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public TopicVo GetTopic(@PathVariable("topic_id") BigInteger topic_id)
    {
        Topic t=commentMapper.selectTopicBytopicID(topic_id);
        TopicVo topicVo=new TopicVo();
        topicVo.setContent(t.getContent());
        topicVo.setHeading(t.getHeading());
        topicVo.setName(loginMapper.selectUserByuserID(t.getUser_id()).getName());
        return topicVo;
    }



    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/comment",method =RequestMethod.POST)
    @ResponseBody
    //测试完毕
    public boolean InsertComment(@RequestBody Comment comment)
    {
        Date date=new Date();
        comment.setTime(date);
        return commentServiceImpl.InsertCommentByBelongingId(comment);
    }

    @ResponseStatus(value=HttpStatus.OK)
    @RequestMapping(value="/topic/{type}/type/{belonging_id}",method =RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public List<Topic> ListTopicByBelonging_id(@PathVariable("type")int type
            ,@PathVariable("belonging_id")BigInteger belong_id){
        return commentServiceImpl.ListAllTopicByBelongingId(type,belong_id);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value="/topic/{type}/type/{belonging_id}",method=RequestMethod.POST)
    @ResponseBody
    //测试完毕。不论前端传回来的是什么时间，都按照调用serice都时间为准
    public Boolean InsertTopic(@PathVariable("type")int type
            ,@PathVariable("belonging_id")BigInteger belong_id,@RequestBody Topic topic){
        Date date=new Date();
        topic.setBelonging_id(belong_id);
        topic.setType(type);
        topic.setTime(date);
        return commentServiceImpl.InsertTopic(topic);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("/comment/{topic_id}"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public List<CommentVo> GetCommentByTopicId(@PathVariable("topic_id")BigInteger topic_id){
        return commentServiceImpl.ListAllCommentByTopicId(topic_id);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("/comment"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕。
    public List<CommentVo> GetCommentByUserId(@RequestParam BigInteger user_id){
        return commentServiceImpl.ListAllCommentByUserId(user_id);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("/topic"),method = RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public List<Topic> GetTopicByUserId(@RequestParam BigInteger user_id){
        return commentServiceImpl.ListAllTopicByUserId(user_id);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("/comment/{topic_id}/me"),method=RequestMethod.GET)
    @ResponseBody
    //测试完毕
    public List<CommentVo> GetCommentByUserIdAndTopicId(@PathVariable BigInteger topic_id
                    ,@RequestParam BigInteger user_id){
        return commentServiceImpl.ListAllCommentByTopicIdAndMe(user_id,topic_id);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("/comment/{comment_id}"),method=RequestMethod.DELETE)
    @ResponseBody
    //测试完毕
    public Boolean DeleteCommentByCommentId(@PathVariable BigInteger comment_id){
        return commentServiceImpl.DeleteCommentById(comment_id);
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @RequestMapping(value=("/topic/{topic_id}"),method=RequestMethod.DELETE)
    @ResponseBody
    //测试完毕
    public Boolean DeleteTopicByTopicId(@PathVariable BigInteger topic_id){
        return commentServiceImpl.DeleteTopicById(topic_id);
    }
}
