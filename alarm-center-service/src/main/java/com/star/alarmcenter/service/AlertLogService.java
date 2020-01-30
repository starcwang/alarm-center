package com.star.alarmcenter.service;

import com.star.alarmcenter.model.vos.AlertLogQueryParamVO;
import com.star.alarmcenter.model.vos.AlertLogVO;
import com.star.alarmcenter.model.vos.Paged;

/**
 * @author wangchao
 * @date 2020/01/30
 */
public interface AlertLogService {

    /**
     * 查询
     *
     * @param param 参数
     * @return {@link Paged<AlertLogVO>}
     */
    Paged<AlertLogVO> query(AlertLogQueryParamVO param);
}
