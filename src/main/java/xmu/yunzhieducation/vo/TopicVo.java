package xmu.yunzhieducation.vo;

import java.math.BigInteger;
import java.util.Date;

public class TopicVo {
    private BigInteger topic_id;
    private BigInteger no;
    private String heading;
    private String content;
    private Date time;
    private BigInteger comment_num;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(BigInteger topic_id) {
        this.topic_id = topic_id;
    }

    public BigInteger getNo() {
        return no;
    }

    public void setNo(BigInteger no) {
        this.no = no;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigInteger getComment_num() {
        return comment_num;
    }

    public void setComment_num(BigInteger comment_num) {
        this.comment_num = comment_num;
    }

    @Override
    public String toString() {
        return "TopicVo{" +
                "no=" + no +
                ", heading='" + heading + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", comment_num=" + comment_num +
                '}';
    }
}
