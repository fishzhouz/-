package xmu.yunzhieducation.vo;

import xmu.yunzhieducation.entity.Comment;

public class CommentVo {
    private Comment comment;
    private String name;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "comment=" + comment +
                ", name='" + name + '\'' +
                '}';
    }
}
