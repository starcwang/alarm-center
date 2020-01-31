package com.star.alarmcenter.common.exception;

import com.star.alarmcenter.common.ErrorCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

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

    public CommonException(ErrorCode errorCode, String message) {
        this(errorCode.getCode(), StringUtils.isBlank(message) ? errorCode.getMsg() : message);
    }

    public CommonException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMsg());
    }
}
