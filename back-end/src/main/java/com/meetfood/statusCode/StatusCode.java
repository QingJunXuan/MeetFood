package com.meetfood.statusCode;

/**
 * 功能：输出的json字段的值是StatusCode类决定
 *      就是说返回状态的值是成功200还是失败400还是错误404，这些值
 *      是StatusCode这个类定义的。
 */
public enum StatusCode {
    /** 成功 */
    SUCCESS(200, "成功"),

    /** 未注册邮箱 */
    FAIL_UNREGISTER(400, "未注册邮箱"),

    /** 邮箱已注册 */
    FAIL_REGISTERED(401, "邮箱已注册"),

    /** 系统错误 */
    SYS_ERROR(402, "系统错误"),

    /** 密码错误 */
    FAIL_PASS(403, "密码错误"),

    /** 格式错误 */
    FAIL_FORMAT(403, "格式错误"),

    /** 不支持或已经废弃 */
    NOT_SUPPORTED(410, "不支持或已经废弃"),

    /** AuthCode错误 */
    INVALID_AUTHCODE(444, "无效的AuthCode"),

    /** 太频繁的调用 */
    TOO_FREQUENT(445, "太频繁的调用"),

    /** 未知的错误 */
    UNKNOWN_ERROR(499, "未知错误");

    private int code;
    private String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


