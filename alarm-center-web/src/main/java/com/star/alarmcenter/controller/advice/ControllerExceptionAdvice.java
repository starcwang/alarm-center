package com.star.alarmcenter.controller.advice;

import com.star.alarmcenter.common.exception.CommonException;
import com.star.alarmcenter.model.vos.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 处理异常
     * CommonException
     *
     * @param ce 异常
     * @return 结果
     */
    @ResponseBody
    @ExceptionHandler(CommonException.class)
    public Result<Void> handleCommonException(CommonException ce) {
        log.warn(ce.getMessage(), ce);
        return Result.fail(ce.getCode(), ce.getMessage());
    }

    /**
     * 处理异常
     * Exception
     *
     * @param e 异常
     * @return 结果
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail();
    }
}
