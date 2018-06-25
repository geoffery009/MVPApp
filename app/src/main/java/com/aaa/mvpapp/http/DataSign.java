package com.aaa.mvpapp.http;

public class DataSign {
    private String data, sign;

    public DataSign(String data, String sign) {
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
