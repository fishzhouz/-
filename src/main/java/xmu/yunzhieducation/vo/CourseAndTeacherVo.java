package xmu.yunzhieducation.vo;

/**
 * 作者陈滨  用于courseservice
 */
public class CourseAndTeacherVo {
    private String course_name;
    private String teacher_name;

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

    @Override
    public String toString() {
        return "CourseAndTeacherVo{" +
                "course_name='" + course_name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                '}';
    }
}
