package xmu.yunzhieducation.vo;

public class ParticipationVo {
    private Integer selected_num;       //已经参与了实习的人数
    private Integer all_student_num;    //选择了课程的总人数

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
