package com.star.alarmcenter.model.dos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * alarm
 *
 * @author wangchao
 * @date 2020/01/22
 */
@Setter
@Getter
@ToString(callSuper = true)
public class AlarmDO extends BaseDO<Long> {

    /**
     * 编码
     */
    private String code;

    /**
     * 组别
     */
    private String group;

    /**
     * 名称
     */
    private String name;

    /**
     * 表达式
     */
    private String expression;

    /**
     * 描述
     */
    private String desc;

    /**
     * 规则
     */
    private String rule;

    /**
     * 报警间隔秒数
     */
    private Integer intervalSeconds;

}
