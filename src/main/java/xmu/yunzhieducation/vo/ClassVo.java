package xmu.yunzhieducation.vo;

import java.math.BigInteger;

public class ClassVo {
    private BigInteger class_id;
    private String name;

    public BigInteger getClass_id() {
        return class_id;
    }

    public void setClass_id(BigInteger class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassVo{" +
                "class_id=" + class_id +
                ", name=" + name +
                '}';
    }
}
