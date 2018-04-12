package xmu.yunzhieducation.vo;

import xmu.yunzhieducation.entity.Trainging;

import java.math.BigInteger;
import java.util.List;

public class TraingingVo2 {
    private Trainging trainging;
    private List<Student> students;

    public Trainging getTrainging() {
        return trainging;
    }

    public void setTrainging(Trainging trainging) {
        this.trainging = trainging;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "TraingingVo2{" +
                "trainging=" + trainging +
                ", students=" + students +
                '}';
    }
}
