package com.star.alarmcenter.service.timer;

import com.star.alarmcenter.model.dos.AlarmDO;

/**
 * 报警次数统计
 *
 * @author wangchao
 * @date 2020/01/23
 */
public interface AlarmTimer {

    /**
     * 打点
     *
     * @param alarm 报警
     * @return boolean
     */
    boolean doPoint(AlarmDO alarm);

}
