package com.star.alarmcenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.alarmcenter.model.dos.EmailAlarmDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * email_alarm
 *
 * @author wangchao
 * @date 2020/01/23
 */
@Mapper
@Repository
public interface EmailAlarmDAO extends BaseMapper<EmailAlarmDO> {

}
