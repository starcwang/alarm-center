package com.star.alarmcenter.model.dos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * dingtalk_robot_alarm
 *
 * @author wangchao
 * @date 2020/01/22
 */
@Setter
@Getter
@ToString(callSuper = true)
public class DingtalkRobotAlarmDO extends BaseDO<Long> {

    /**
     * alarm表主键
     */
    private Long alarmId;

    /**
     * 需要at的手机号，英文逗号分隔
     */
    private String atMobiles;

    /**
     * 是否at全员
     */
    private Integer isAtAll;

    /**
     * 自定义关键词
     */
    private String keyword;

    /**
     * 签名
     */
    private String signature;
}
