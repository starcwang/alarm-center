package com.star.alarmcenter.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

    /**
     * 通过code和group查询
     *
     * @param groups 分组
     * @param code 代码
     * @return {@link AlarmDO}
     */
    public AlarmDO getByCode(String groups, String code) {
        QueryWrapper<AlarmDO> wrapper = Wrappers.query();
        wrapper.eq(AlarmDO.CONST_GROUPS, groups);
        wrapper.eq(AlarmDO.CONST_CODE, code);
        return baseMapper.selectOne(wrapper);
    }
}
