package com.star.alarmcenter.manager;

import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.alarmcenter.dao.AlertLogDAO;
import com.star.alarmcenter.model.dos.AlertLogDO;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @date 2020/01/28
 */
@Component
public class AlertLogManager extends ServiceImpl<AlertLogDAO, AlertLogDO> {

    /**
     * 统计个数
     *
     * @param alarmId 警告标识
     * @param beforeMilliseconds 时间间隔
     * @return int
     */
    public int countByTimeLength(long alarmId, long beforeMilliseconds) {
        QueryWrapper<AlertLogDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(AlertLogDO.CONST_ALARM_ID, alarmId);
        queryWrapper.ge(AlertLogDO.CONST_GMT_CREATE, DateUtils.addMilliseconds(new Date(), -(int)beforeMilliseconds));
        return count(queryWrapper);
    }
}
