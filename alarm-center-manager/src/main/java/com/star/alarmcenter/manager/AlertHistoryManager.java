package com.star.alarmcenter.manager;

import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.alarmcenter.dao.AlertHistoryDAO;
import com.star.alarmcenter.model.dos.AlertHistoryDO;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Component
public class AlertHistoryManager extends ServiceImpl<AlertHistoryDAO, AlertHistoryDO> {
    /**
     * 统计个数
     *
     * @param alarmId 警告标识
     * @param beforeMilliseconds 时间间隔
     * @return int
     */
    public int countByTimeLength(long alarmId, long beforeMilliseconds) {
        QueryWrapper<AlertHistoryDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(AlertHistoryDO.CONST_ALARM_ID, alarmId);
        queryWrapper.ge(AlertHistoryDO.CONST_GMT_CREATE, DateUtils.addMilliseconds(new Date(), -(int)beforeMilliseconds));
        return count(queryWrapper);
    }
}
