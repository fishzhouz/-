package xmu.yunzhieducation.vo;

import xmu.yunzhieducation.entity.Trainging;

public class TraingingVo {
    private Trainging trainging;
    private boolean is_upload;

    public Trainging getTrainging() {
        return trainging;
    }

    public void setTrainging(Trainging trainging) {
        this.trainging = trainging;
    }

    public boolean isIs_upload() {
        return is_upload;
    }

    public void setIs_upload(boolean is_upload) {
        this.is_upload = is_upload;
    }

    @Override
    public String toString() {
        return "TraingingVo{" +
                "trainging=" + trainging +
                ", is_upload=" + is_upload +
                '}';
    }
}
