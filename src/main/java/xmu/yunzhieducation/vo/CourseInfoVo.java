package xmu.yunzhieducation.vo;

import xmu.yunzhieducation.entity.Course;
/**
 * 作者陈滨  用于courseservice
 */
public class CourseInfoVo {
    private boolean is_choose;//学生是否有选该门课程
    private Integer num;//课程总人数
    private Course course;//课程基本信息
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_choose() {
        return is_choose;
    }

    public void setIs_choose(boolean is_choose) {
        this.is_choose = is_choose;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseInfoVo{" +
                "is_choose=" + is_choose +
                ", num=" + num +
                ", course=" + course +
                '}';
    }
}
