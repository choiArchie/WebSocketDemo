package com.ex.demo;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:    外层实体
 */
@SuppressWarnings("all")
public class CommonResponseEntity {
    private int code;
    private String msg;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
