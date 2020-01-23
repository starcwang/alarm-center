package com.star.alarmcenter.model.bos;

import java.util.List;

import com.star.alarmcenter.model.dos.DingtalkRobotAlarmDO;
import com.star.alarmcenter.model.dos.EmailAlarmDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Setter
@Getter
@ToString
public class AlarmBO {

    /** 编码 */
    private String code;

    /** 组别 */
    private String group;

    /** 名称 */
    private String name;

    /** 表达式 */
    private String expression;

    /** 描述 */
    private String desc;

    /** 规则 */
    private String rule;

    /** 报警间隔秒数 */
    private Integer intervalSeconds;

    /** dingtalk机器人报警列表 */
    private List<DingtalkRobotAlarmDO> dingtalkRobotAlarmList;

    /** 电子邮件警报列表 */
    private List<EmailAlarmDO> emailAlarmList;

}
