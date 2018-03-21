package xmu.yunzhieducation.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Comment;
import xmu.yunzhieducation.entity.Topic;
import xmu.yunzhieducation.mapper.CommentMapper;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void testInsertTopicByID() {
        Topic t = new Topic();
        t.setBelonging_id(new BigInteger("1"));
        t.setTime(new Date(118, 3, 4, 12, 34, 56));
        t.setType(0);
        t.setUser_id(new BigInteger("1"));
        t.setHeading("计网考什么呀");
        t.setContent("如题");
        commentMapper.insertTopicByID(t);
    }

    @Test
    public void testDeleteTopicByID() {
        commentMapper.deleteTopicByID(new BigInteger("4"));
    }

    @Test
    public void testInsertCommentByID()
    {
        Comment c=new Comment();
        c.setContent("茶餐厅");
        c.setTime(new Date(118,3,4,12,35,56));
        c.setTopic_id(new BigInteger("1"));
        c.setUser_id(new BigInteger("5"));
        commentMapper.insertCommentByID(c);
    }

    @Test
    public void testDeleteCommentByID()
    {
        commentMapper.deleteCommentByID(new BigInteger("4"));
    }

    @Test
    public void testSelectTopicBybelongingID()
    {
        List<Topic> topics=commentMapper.selectTopicBybelongingID(new BigInteger("1"),0);
        for(Topic t:topics)
        {
            System.out.println(t);
        }
    }

    @Test
    public void testSelectTopicByuserID()
    {
        List<Topic> topics=commentMapper.selectTopicByuserID(new BigInteger("3"));
        for(Topic t:topics)
        {
            System.out.println(t);
        }
    }

    @Test
    public void testSelectCommentBytopicID()
    {
        List<Comment> comments=commentMapper.selectCommentBytopicID(new BigInteger("1"));
        for(Comment c:comments)
        {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectCommentByuserID()
    {
        List<Comment> comments=commentMapper.selectCommentByuserID(new BigInteger("5"));
        for(Comment c:comments)
        {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectTopicBycommentID()
    {
        BigInteger topic=commentMapper.selectTopicBycommentID(new BigInteger("1"));
        System.out.println(topic);
    }

    @Test
    public void testSelectCommentBytopicIDAnduserID()
    {
        List<Comment> mycomments=commentMapper.selectCommentBytopicIDAnduserID(new BigInteger("1"),new BigInteger("5"));
        for(Comment  c:mycomments)
        {
            System.out.println(c);
        }
    }
}
