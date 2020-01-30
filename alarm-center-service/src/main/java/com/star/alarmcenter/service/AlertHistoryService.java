package com.star.alarmcenter.service;

import com.star.alarmcenter.model.vos.AlertHistoryQueryParamVO;
import com.star.alarmcenter.model.vos.AlertHistoryVO;
import com.star.alarmcenter.model.vos.Paged;

/**
 * @author wangchao
 * @date 2020/01/30
 */
public interface AlertHistoryService {

    /**
     * 查询
     *
     * @param param 参数
     * @return {@link Paged<AlertHistoryVO>}
     */
    Paged<AlertHistoryVO> query(AlertHistoryQueryParamVO param);
}
