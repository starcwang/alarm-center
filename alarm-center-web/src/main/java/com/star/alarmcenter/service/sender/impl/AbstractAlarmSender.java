package com.star.alarmcenter.service.sender.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.model.dos.BaseAlarmIdRequiredDO;
import com.star.alarmcenter.service.sender.AlarmSender;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangchao
 * @date 2020/01/31
 */
public abstract class AbstractAlarmSender<M extends BaseMapper<T>, T extends BaseAlarmIdRequiredDO> implements AlarmSender {

    @Autowired
    private M baseMapper;

    @Override
    public void send(AlarmDO alarm, String locate, String message, List<String> stackTraceList) {
        if (alarm == null || alarm.getId() == null) {
            return;
        }
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq(BaseAlarmIdRequiredDO.CONST_ALARM_ID, alarm.getId());
        List<T> alarmList = baseMapper.selectList(wrapper);
        for (T t : alarmList) {
            doSend(alarm, t, locate, message, stackTraceList);
        }
    }

    /**
     * 执行发送
     *
     * @param alarm 报警
     * @param t t
     * @param locate 定位
     * @param message 消息
     * @param stackTraceList 堆栈跟踪列表
     */
    protected abstract void doSend(AlarmDO alarm, T t, String locate, String message, List<String> stackTraceList);
}
