package com.star.alarmcenter.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.alarmcenter.dao.EmailAlarmDAO;
import com.star.alarmcenter.model.dos.EmailAlarmDO;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Component
public class EmailAlarmManager extends ServiceImpl<EmailAlarmDAO, EmailAlarmDO> {
}
