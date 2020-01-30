package com.star.alarmcenter.model.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * alert_log
 *
 * @author wangchao
 * @date 2020/01/28
 */
@Setter
@Getter
@ToString(callSuper = true)
@TableName("alert_log")
public class AlertLogDO extends BaseDO<Long> {
    /** alarm表主键 */
    private Long alarmId;
    /** 定位 */
    private String locate;
    /** 消息 */
    private String message;
    /** 堆栈跟踪 */
    private String stackTrace;

    /** 常量 */
    public static final String CONST_ALARM_ID = "alarmId";
}
