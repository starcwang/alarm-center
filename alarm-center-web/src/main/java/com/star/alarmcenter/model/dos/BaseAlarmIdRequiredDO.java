package com.star.alarmcenter.model.dos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@Getter
@Setter
@ToString(callSuper = true)
public abstract class BaseAlarmIdRequiredDO extends BaseDO {

    /** alarm表主键 */
    private Long alarmId;

    /** 常量 */
    public static final String CONST_ALARM_ID = "alarmId";

}
