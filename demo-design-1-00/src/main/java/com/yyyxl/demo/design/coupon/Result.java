package com.yyyxl.demo.design.coupon;

public class Result {
    private String Code;
    private String info;

    public Result(String code, String info) {
        Code = code;
        this.info = info;
    }

    public Result() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
