package com.star.alarmcenter.model.vos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class AlarmVO {

    /** 主键标识 */
    private Long id;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

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
    private Integer status;

    /** 规则 */
    private String rule;

    /** 报警间隔秒数 */
    private Integer intervalSeconds;
}
