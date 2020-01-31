package com.star.alarmcenter.model.vos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangchao
 * @date 2020/01/30
 */
@Getter
@Setter
@ToString
public class AlarmInsertParamVO {

    /** 编码 */
    private String code;
    /** 组别 */
    private String groups;
    /** 名称 */
    private String name;
    /** 表达式 */
    private String expression;
    /** 描述 */
    private String description;
    /** 规则 */
    private String rule;
    /** 报警间隔秒数 */
    private Integer intervalSeconds;

}
