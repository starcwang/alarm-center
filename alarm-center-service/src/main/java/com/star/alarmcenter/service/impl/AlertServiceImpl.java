package com.star.alarmcenter.service.impl;

import javax.annotation.Resource;

import com.star.alarmcenter.common.ErrorCode;
import com.star.alarmcenter.common.enums.AlarmStatus;
import com.star.alarmcenter.common.exception.CommonException;
import com.star.alarmcenter.common.util.JsonUtil;
import com.star.alarmcenter.manager.AlarmManager;
import com.star.alarmcenter.manager.AlertHistoryManager;
import com.star.alarmcenter.manager.AlertLogManager;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.model.dos.AlertHistoryDO;
import com.star.alarmcenter.model.dos.AlertLogDO;
import com.star.alarmcenter.model.vos.AlertLogParamVO;
import com.star.alarmcenter.service.AlertService;
import com.star.alarmcenter.service.sender.AlarmSenderService;
import com.star.alarmcenter.service.timer.AlarmTimer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangchao
 * @date 2020/01/28
 */
@Service
public class AlertServiceImpl implements AlertService {

    @Resource
    private AlarmSenderService alarmSenderService;

    @Resource
    private AlarmTimer alarmTimer;

    @Resource
    private AlarmManager alarmManager;

    @Resource
    private AlertHistoryManager alertHistoryManager;

    @Resource
    private AlertLogManager alertLogManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void log(AlertLogParamVO param) {
        AlarmDO alarm = alarmManager.getByCode(param.getGroups(), param.getCode());
        if (alarm == null) {
            throw new CommonException(ErrorCode.BUSINESS_ERROR.getCode(), "alarm不存在");
        }
        // 不可用
        if (AlarmStatus.CLOSE.equals(alarm.getStatus())) {
            return;
        }
        // 记录打点
        AlertLogDO alarmPoint = new AlertLogDO();
        alarmPoint.setAlarmId(alarm.getId());
        alarmPoint.setLocate(param.getLocate());
        alarmPoint.setMessage(param.getMessage());
        alarmPoint.setStackTrace(JsonUtil.toJson(param.getStackTraceList()));
        alertLogManager.getBaseMapper().insert(alarmPoint);

        if (alarmTimer.doPoint(alarm)) {
            // 发送报警
            alarmSenderService.asyncSend(alarm, param.getLocate(), param.getMessage(), param.getStackTraceList());
            // 记录报警次数
            AlertHistoryDO alarmLog = new AlertHistoryDO();
            alarmLog.setAlarmId(alarm.getId());
            alertHistoryManager.getBaseMapper().insert(alarmLog);
        }
    }
}
