package com.star.alarmcenter.common.exception;

import lombok.Getter;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Getter
public class CommonException extends RuntimeException {

    /** 编码 */
    private final int code;

    public CommonException(int code, String message) {
        super(message);
        this.code = code;
    }
}
