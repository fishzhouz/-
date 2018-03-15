package xmu.yunzhieducation.entity;

import java.math.BigInteger;

public class Class1 {
    private BigInteger id;
    private BigInteger course_id;
    private Integer student_num;
    private String class_name;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getCourse_id() {
        return course_id;
    }

    public void setCourse_id(BigInteger course_id) {
        this.course_id = course_id;
    }

    public Integer getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Integer student_num) {
        this.student_num = student_num;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Class1{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", student_num=" + student_num +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
