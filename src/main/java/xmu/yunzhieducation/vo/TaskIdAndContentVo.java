package xmu.yunzhieducation.vo;

import java.math.BigInteger;

public class TaskIdAndContentVo {
    private BigInteger task_id;
    private String content;
    private boolean is_finished;

    public BigInteger getTask_id() {
        return task_id;
    }

    public void setTask_id(BigInteger task_id) {
        this.task_id = task_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIs_finished() {
        return is_finished;
    }

    public void setIs_finished(boolean is_finished) {
        this.is_finished = is_finished;
    }

    @Override
    public String toString() {
        return "TaskIdAndContentVo{" +
                "task_id=" + task_id +
                ", content='" + content + '\'' +
                '}';
    }
}
