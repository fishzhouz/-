package xmu.yunzhieducation.vo;

public class ParticipationVo {
    private Integer selected_num;       //上传实训报告的学生数目
    private Integer all_student_num;    //课程下的实训学生数目

    public Integer getSelected_num() {
        return selected_num;
    }

    public void setSelected_num(Integer selected_num) {
        this.selected_num = selected_num;
    }

    public Integer getAll_student_num() {
        return all_student_num;
    }

    public void setAll_student_num(Integer all_student_num) {
        this.all_student_num = all_student_num;
    }

    @Override
    public String toString() {
        return "ParticipationVo{" +
                "selected_num=" + selected_num +
                ", all_student_num=" + all_student_num +
                '}';
    }
}
