package com.star.alarmcenter.service.sender.impl;

import javax.annotation.Resource;

import com.star.alarmcenter.model.dos.DingtalkRobotAlarmDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DingtalkRobotAlarmSenderTest {

    @Resource
    private DingtalkRobotAlarmSender dingtalkRobotAlarmSender;

    @Test
    public void doSend() {
        DingtalkRobotAlarmDO dingtalkRobotAlarm = new DingtalkRobotAlarmDO();
        dingtalkRobotAlarm.setWebhook("https://oapi.dingtalk.com/robot/send?access_token=7c4382507a32907899047fd3afb847bba20121dbff3abbd5f5747d1f426e75f4");
        dingtalkRobotAlarm.setAtMobiles("");
        dingtalkRobotAlarm.setIsAtAll(1);
        dingtalkRobotAlarm.setKeyword("666");
        dingtalkRobotAlarm.setSecret("SEC4c93e9cc5aa39108260d6ac573544acf804077373135c41c50174721d68e6e33");
        dingtalkRobotAlarm.setAlarmId(1L);

        dingtalkRobotAlarmSender.doSend(null, dingtalkRobotAlarm, "天津市", "大家好", null);
    }
}