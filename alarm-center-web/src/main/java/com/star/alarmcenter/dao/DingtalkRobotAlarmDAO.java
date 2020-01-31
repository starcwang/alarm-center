package com.star.alarmcenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.alarmcenter.model.dos.DingtalkRobotAlarmDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * dingtalk_robot_alarm
 *
 * @author wangchao
 * @date 2020/01/23
 */
@Mapper
@Repository
public interface DingtalkRobotAlarmDAO extends BaseMapper<DingtalkRobotAlarmDO> {

}
