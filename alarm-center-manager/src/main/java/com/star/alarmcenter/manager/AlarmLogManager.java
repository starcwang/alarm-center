package com.star.alarmcenter.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.alarmcenter.dao.AlarmLogDAO;
import com.star.alarmcenter.model.dos.AlarmLogDO;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Component
public class AlarmLogManager extends ServiceImpl<AlarmLogDAO, AlarmLogDO> {
}
