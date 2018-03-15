package xmu.yunzhieducation.entity;

import java.math.BigInteger;
import java.util.Date;

public class Comment {
    private BigInteger id;
    private BigInteger topic_id;
    private String content;
    private Date time;
    private BigInteger user_id;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(BigInteger topic_id) {
        this.topic_id = topic_id;
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

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", topic_id=" + topic_id +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", user_id=" + user_id +
                '}';
    }
}
