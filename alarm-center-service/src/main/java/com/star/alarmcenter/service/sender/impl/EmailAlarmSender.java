package com.star.alarmcenter.service.sender.impl;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.star.alarmcenter.manager.EmailAlarmManager;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.model.dos.EmailAlarmDO;
import com.star.alarmcenter.service.sender.AlarmSender;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@Component
public class EmailAlarmSender implements AlarmSender {

    @Resource
    private EmailAlarmManager emailAlarmManager;

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void send(AlarmDO alarm, String locate, String message, List<String> stackTraceList) {
        if (alarm == null || alarm.getId() == null) {
            return;
        }
        QueryWrapper<EmailAlarmDO> wrapper = new QueryWrapper<>();
        wrapper.eq(EmailAlarmDO.CONST_ALARM_ID, alarm.getId());
        List<EmailAlarmDO> emailAlarmList = emailAlarmManager.getBaseMapper().selectList(wrapper);
        for (EmailAlarmDO emailAlarm : emailAlarmList) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("报警中心");
            mailMessage.setTo(StringUtils.split(emailAlarm.getEmail(), ","));
            mailMessage.setSubject(String.format("报警-%s-%s", alarm.getRule(), message));
            mailMessage.setText(String.format("%s</br>%s</br>%s", message, locate, StringUtils.join(stackTraceList, "</br>")));
            javaMailSender.send(mailMessage);
        }
    }
}
