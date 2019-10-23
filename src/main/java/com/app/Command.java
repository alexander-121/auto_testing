package com.app;

public class Command {

    private String act;
    private String param;
    private String desc;

    public Command(String act, String param, String desc) {
        this.act = act;
        this.param = param;
        this.desc = desc;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
