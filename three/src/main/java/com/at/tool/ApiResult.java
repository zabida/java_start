package com.at.tool;

public class ApiResult<T> {
    private int code;
    private String msg;
    private T data;

    // 无参构造函数
    public ApiResult() {}

    public ApiResult(String msg, Integer code, T t){
        this.code = code;
        this.msg = msg;
        this.data = t;
    }
    // Getters and setters
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
