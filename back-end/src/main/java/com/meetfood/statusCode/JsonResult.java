package com.meetfood.statusCode;

/**
 * 这个类定义了返回的json格式，即json含有哪些字段
 */
public class JsonResult {
    private int code;
    private String message;
    private Object date;

    public JsonResult(int code, String message, Object date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getDate() {
        return date;
    }
}

