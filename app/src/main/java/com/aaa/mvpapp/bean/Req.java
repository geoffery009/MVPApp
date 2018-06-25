package com.aaa.mvpapp.bean;

public class Req {
    private String data,sign;

    public Req(String data, String sign) {
        this.data = data;
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
