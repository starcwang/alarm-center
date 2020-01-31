package com.star.alarmcenter.model.dos;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("dingtalk_robot_alarm")
public class DingtalkRobotAlarmDO extends BaseAlarmIdRequiredDO {

    /**
     * 地址
     */
    private String webhook;

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
     * 秘钥
     */
    private String secret;
}
