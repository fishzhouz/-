package xmu.yunzhieducation.vo;

import java.util.Date;

public class TraingingVo3 {
    private String name;
    private Date start_time;
    private Date end_time;
    private Integer num;
    private Integer g1;//60分以下
    private Integer g2;//60-69
    private Integer g3;//70-79
    private Integer g4;//80-89
    private Integer g5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getG1() {
        return g1;
    }

    public void setG1(Integer g1) {
        this.g1 = g1;
    }

    public Integer getG2() {
        return g2;
    }

    public void setG2(Integer g2) {
        this.g2 = g2;
    }

    public Integer getG3() {
        return g3;
    }

    public void setG3(Integer g3) {
        this.g3 = g3;
    }

    public Integer getG4() {
        return g4;
    }

    public void setG4(Integer g4) {
        this.g4 = g4;
    }

    public Integer getG5() {
        return g5;
    }

    public void setG5(Integer g5) {
        this.g5 = g5;
    }

    @Override
    public String toString() {
        return "TraingingVo3{" +
                "name='" + name + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", num=" + num +
                ", g1=" + g1 +
                ", g2=" + g2 +
                ", g3=" + g3 +
                ", g4=" + g4 +
                ", g5=" + g5 +
                '}';
    }
}
