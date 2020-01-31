package com.star.alarmcenter.service;

import com.star.alarmcenter.model.vos.AlarmInsertParamVO;
import com.star.alarmcenter.model.vos.AlarmPutParamVO;
import com.star.alarmcenter.model.vos.AlarmQueryParamVO;
import com.star.alarmcenter.model.vos.AlarmVO;
import com.star.alarmcenter.model.vos.Paged;

/**
 * @author wangchao
 * @date 2020/01/30
 */
public interface AlarmService {

    /**
     * 查询
     *
     * @param param 参数
     * @return {@link Paged<AlarmVO>}
     */
    Paged<AlarmVO> query(AlarmQueryParamVO param);

    /**
     * 获取
     *
     * @param id id
     * @return {@link AlarmVO}
     */
    AlarmVO get(Long id);

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    boolean delete(Long id);

    /**
     * 更新
     *
     * @param id id
     * @param param 参数
     * @return boolean
     */
    boolean update(Long id, AlarmPutParamVO param);

    /**
     * 插入
     *
     * @param param 参数
     * @return boolean
     */
    boolean insert(AlarmInsertParamVO param);
}
