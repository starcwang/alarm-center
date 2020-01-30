package com.star.alarmcenter.model.vos;

import java.util.Date;

import com.star.alarmcenter.common.enums.AlarmStatus;
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
public class AlertLogVO {

    /** id */
    private Long id;

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

    /** 状态 */
    private AlarmStatus status;

    /** 规则 */
    private String rule;

    /** 报警间隔秒数 */
    private Integer intervalSeconds;

    /** 定位 */
    private String locate;

    /** 消息 */
    private String message;

    /** 堆栈跟踪 */
    private String stackTrace;

    /** 提醒时间 */
    private Date logTime;

}
