package com.star.alarmcenter.service.sender.impl;

import java.util.List;

import javax.annotation.Resource;

import com.star.alarmcenter.dao.EmailAlarmDAO;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.model.dos.EmailAlarmDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @date 2020/01/31
 */
@Component
public class EmailAlarmSender extends AbstractAlarmSender<EmailAlarmDAO, EmailAlarmDO> {

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    protected void doSend(AlarmDO alarm, EmailAlarmDO emailAlarm, String locate, String message, List<String> stackTraceList) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("报警中心");
        mailMessage.setTo(StringUtils.split(emailAlarm.getEmail(), ","));
        mailMessage.setSubject(String.format("报警-%s-%s", alarm.getRule(), message));
        mailMessage.setText(String.format("%s</br>%s</br>%s", message, locate, StringUtils.join(stackTraceList, "</br>")));
        javaMailSender.send(mailMessage);
    }
}
