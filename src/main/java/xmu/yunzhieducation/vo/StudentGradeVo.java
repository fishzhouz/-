package xmu.yunzhieducation.vo;

import java.math.BigInteger;

public class StudentGradeVo {
    private BigInteger student_id;
    private String name;
    private Integer grade;

    public BigInteger getStudent_id() {
        return student_id;
    }

    public void setStudent_id(BigInteger student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentGradeVo{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
