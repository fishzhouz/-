package xmu.yunzhieducation.vo;

public class WrongQuestionVo {
    private String Heading;
    private String A;
    private String B;
    private String C;
    private String D;
    private char answer;
    private char wrong_answer;

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
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
                "Heading='" + Heading + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", answer='" + answer + '\'' +
                ", wrong_answer='" + wrong_answer + '\'' +
                '}';
    }
}
