package com.star.alarmcenter.service;

import com.star.alarmcenter.model.vos.AlertLogParamVO;

/**
 * @author wangchao
 * @date 2020/01/28
 */
public interface AlertService {

    /**
     * 打点
     *
     * @param param 参数
     */
    void log(AlertLogParamVO param);
}
