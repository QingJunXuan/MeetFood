package com.meetfood.statusCode;

import java.util.List;

/**
 * 这个类定义了返回的json格式，即json含有哪些字段
 */
public class JsonResult {
    private int code;
    private List message;
    private Object date;

    public JsonResult(int code, List message, Object date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }
    public JsonResult(int code,Object date){
        this.code = code;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public List getMessage() {
        return message;
    }

    public Object getDate() {
        return date;
    }
}

