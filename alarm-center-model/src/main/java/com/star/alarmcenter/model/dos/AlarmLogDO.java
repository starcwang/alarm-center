package com.star.alarmcenter.model.dos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * alarm_log
 *
 * @author wangchao
 * @date 2020/01/22
 */
@Setter
@Getter
@ToString(callSuper = true)
public class AlarmLogDO extends BaseDO<Long> {

    /**
     * alarm表主键
     */
    private Long alarmId;
}
