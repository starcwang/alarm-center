package com.star.alarmcenter.model.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * email_alarm
 *
 * @author wangchao
 * @date 2020/01/22
 */
@Setter
@Getter
@ToString(callSuper = true)
@TableName("email_alarm")
public class EmailAlarmDO extends BaseDO<Long> {

    /**
     * alarm表主键
     */
    private Long alarmId;

    /**
     * 英文逗号分隔的邮箱
     */
    private String email;
}
