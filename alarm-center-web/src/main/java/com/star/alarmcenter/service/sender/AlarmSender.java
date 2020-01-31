package com.star.alarmcenter.service.sender;

import java.util.List;

import com.star.alarmcenter.model.dos.AlarmDO;

/**
 * @author wangchao
 * @date 2020/01/23
 */
public interface AlarmSender {
    /**
     * 发送
     *
     * @param message 消息
     * @param locate 定位
     * @param stackTraceList 堆栈跟踪列表
     * @param alarm 报警
     */
    void send(AlarmDO alarm, String locate, String message, List<String> stackTraceList);
}
