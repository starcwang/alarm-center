package com.star.alarmcenter.model.dos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangchao
 * @date 2020/01/21
 */
@Getter
@Setter
@ToString(callSuper = true)
public class AlarmDO extends BaseDO<Long> {

    /** 代码 */
    private String code;

}
