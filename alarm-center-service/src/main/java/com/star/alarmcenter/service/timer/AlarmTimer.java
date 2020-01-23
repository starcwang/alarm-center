package com.star.alarmcenter.service.timer;

import com.star.alarmcenter.model.bos.AlarmBO;

/**
 * @author wangchao
 * @date 2020/01/23
 */
public interface AlarmTimer {

    boolean time(AlarmBO alarm);

}
