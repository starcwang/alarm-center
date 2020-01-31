package com.star.alarmcenter.model.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.star.alarmcenter.common.enums.AlarmStatus;
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
@TableName("alarm")
public class AlarmDO extends BaseDO {

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

    /** 常量 */
    public static final String CONST_GROUPS = "groups";
    public static final String CONST_CODE = "code";
}
