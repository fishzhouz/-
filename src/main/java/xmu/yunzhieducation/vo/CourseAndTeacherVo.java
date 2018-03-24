package xmu.yunzhieducation.vo;

import java.math.BigInteger;

/**
 * 作者陈滨  用于courseservice
 */
public class CourseAndTeacherVo {
    private BigInteger course_id;
    private BigInteger class_id;
    private String course_name;
    private String teacher_name;
    private String picture;

    public BigInteger getCourse_id() {
        return course_id;
    }

    public void setCourse_id(BigInteger course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigInteger getClass_id() {
        return class_id;
    }

    public void setClass_id(BigInteger class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "CourseAndTeacherVo{" +
                "course_id=" + course_id +
                ", class_id=" + class_id +
                ", course_name='" + course_name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
