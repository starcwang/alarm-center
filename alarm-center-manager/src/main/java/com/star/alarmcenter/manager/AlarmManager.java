package com.star.alarmcenter.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.alarmcenter.dao.AlarmDAO;
import com.star.alarmcenter.model.dos.AlarmDO;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Component
public class AlarmManager extends ServiceImpl<AlarmDAO, AlarmDO> {
}
