package com.star.alarmcenter.common;

/**
 * 状态码
 *
 * @author wangchao
 * @date 2020/01/28
 */
public enum ErrorCode {

    /** 成功 */
    SUCCESS(0, "成功"),
    /** 参数错误 */
    PARAM_ERROR(4001, "参数错误"),
    /** 业务错误 */
    BUSINESS_ERROR(5001, "业务异常"),
    /** 未知的错误 */
    UNKNOWN_ERROR(5000, "未知异常"),
    ;
    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
