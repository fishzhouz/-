package xmu.yunzhieducation.vo;

public class CerVo {
    Integer sum;
    Integer join;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getJoin() {
        return join;
    }

    public void setJoin(Integer join) {
        this.join = join;
    }

    @Override
    public String toString() {
        return "CerVo{" +
                "sum=" + sum +
                ", join=" + join +
                '}';
    }
}
