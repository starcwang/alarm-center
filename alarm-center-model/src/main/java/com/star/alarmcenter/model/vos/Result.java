package com.star.alarmcenter.model.vos;

import com.star.alarmcenter.common.exception.CommonException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Setter
@Getter
@ToString
public class Result<T> {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 状态码
     *
     * @see HttpStatus
     */
    private int code;
    /**
     * 描述
     */
    private String desc;
    /**
     * 时间戳
     */
    private long timestamp;
    /**
     * 数据
     */
    private T data;

    public static <R> Result<R> success(R data) {
        Result<R> result = new Result<>();
        result.setSuccess(true);
        result.setCode(HttpStatus.OK.value());
        result.setDesc("");
        result.setTimestamp(System.currentTimeMillis());
        result.setData(data);
        return result;
    }

    public static <R> Result<R> success() {
        return success(null);
    }

    public static <R> Result<R> fail(int code, String desc, R data) {
        Result<R> result = new Result<>();
        result.setSuccess(false);
        result.setCode(code);
        result.setDesc(desc);
        result.setTimestamp(System.currentTimeMillis());
        result.setData(data);
        return result;
    }

    public static <R> Result<R> fail(R data, String desc) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), desc, data);
    }

    public static <R> Result<R> fail(String desc) {
        return fail(null, desc);
    }

    public static <R> Result<R> fail(int code, String desc) {
        return fail(code, desc, null);
    }

    public static <R> Result<R> fail(Exception e) {
        if (e instanceof CommonException) {
            return fail(((CommonException)e).getCode(), e.getMessage());
        }
        return fail(null, e.getMessage());
    }
}
