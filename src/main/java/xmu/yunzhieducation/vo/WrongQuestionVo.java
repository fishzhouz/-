package xmu.yunzhieducation.vo;

public class WrongQuestionVo {
    private String heading;
    private String a;
    private String b;
    private String c;
    private String d;
    private char answer;
    private char wrong_answer;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    public char getWrong_answer() {
        return wrong_answer;
    }

    public void setWrong_answer(char wrong_answer) {
        this.wrong_answer = wrong_answer;
    }

    @Override
    public String toString() {
        return "WrongQuestionVo{" +
                "Heading='" + heading + '\'' +
                ", A='" + a + '\'' +
                ", B='" + b + '\'' +
                ", C='" + c + '\'' +
                ", D='" + d + '\'' +
                ", answer='" + answer + '\'' +
                ", wrong_answer='" + wrong_answer + '\'' +
                '}';
    }
}
