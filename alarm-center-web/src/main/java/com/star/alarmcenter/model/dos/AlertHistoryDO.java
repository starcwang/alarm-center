package com.star.alarmcenter.model.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * alert_history
 *
 * @author wangchao
 * @date 2020/01/22
 */
@Setter
@Getter
@ToString(callSuper = true)
@TableName("alert_history")
public class AlertHistoryDO extends BaseAlarmIdRequiredDO {

}
