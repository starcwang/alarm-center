package com.star.alarmcenter.service.timer.impl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.google.common.collect.ImmutableMap;
import com.star.alarmcenter.manager.AlertHistoryManager;
import com.star.alarmcenter.manager.AlertLogManager;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.service.timer.AlarmTimer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author wangchao
 * @date 2020/01/24
 */
@Service
public class AlarmTimerImpl implements AlarmTimer {
    /** 分隔符 */
    private static final String SEPARATOR = "->";
    /** 时间单位映射 */
    private static final Map<String, TimeUnit> TIME_UNIT_MAP = ImmutableMap.<String, TimeUnit>builder()
        .put("d", TimeUnit.DAYS)
        .put("h", TimeUnit.HOURS)
        .put("m", TimeUnit.MINUTES)
        .put("s", TimeUnit.SECONDS)
        .build();

    @Resource
    private AlertLogManager alertLogManager;

    @Resource
    private AlertHistoryManager alertHistoryManager;

    @Override
    public boolean doPoint(AlarmDO alarm) {
        String[] splits = StringUtils.split(alarm.getRule(), SEPARATOR);
        String num = splits[0];
        // 报警次数是否符合阈值
        int count = alertLogManager.countByTimeLength(alarm.getId(), getTimeLength(splits[1]));
        boolean isAlert = Integer.parseInt(num) >= count;
        if (isAlert) {
            // 发送次数是否符合阈值
            isAlert = alertHistoryManager.countByTimeLength(alarm.getId(), alarm.getIntervalSeconds() * 1000L) <= 0;
        }
        return isAlert;
    }

    private long getTimeLength(String str) {
        StringBuilder numStr = new StringBuilder();
        StringBuilder timeUnit = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numStr.append(c);
            } else {
                timeUnit.append(c);
            }
        }
        return TIME_UNIT_MAP.get(timeUnit.toString()).toMillis(Long.parseLong(numStr.toString()));
    }
}
