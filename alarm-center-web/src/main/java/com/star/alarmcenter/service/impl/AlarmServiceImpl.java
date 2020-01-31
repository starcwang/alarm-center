package com.star.alarmcenter.service.impl;

import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.alarmcenter.common.ErrorCode;
import com.star.alarmcenter.common.enums.AlarmStatus;
import com.star.alarmcenter.common.exception.CommonException;
import com.star.alarmcenter.dao.AlarmDAO;
import com.star.alarmcenter.manager.AlarmManager;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.model.vos.AlarmInsertParamVO;
import com.star.alarmcenter.model.vos.AlarmPutParamVO;
import com.star.alarmcenter.model.vos.AlarmQueryParamVO;
import com.star.alarmcenter.model.vos.AlarmVO;
import com.star.alarmcenter.model.vos.Paged;
import com.star.alarmcenter.service.AlarmService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author wangchao
 * @date 2020/01/30
 */
@Service
public class AlarmServiceImpl implements AlarmService {

    @Resource
    private AlarmDAO alarmDAO;

    @Resource
    private AlarmManager alarmManager;

    @Override
    public Paged<AlarmVO> query(AlarmQueryParamVO param) {
        Page<AlarmDO> page = new Page<>(ObjectUtils.defaultIfNull(param.getPageNum(), 1),
            ObjectUtils.defaultIfNull(param.getPageSize(), 50));
        IPage<AlarmDO> alarmPage = alarmDAO.query(page, param);
        return new Paged<>(alarmPage.getTotal(),
            alarmPage.getRecords().stream().map(this::convert).collect(Collectors.toList()));
    }

    @Override
    public AlarmVO get(Long id) {
        AlarmDO alarmDO = alarmDAO.selectById(id);
        if (alarmDO == null) {
            return null;
        }
        return convert(alarmDO);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            return false;
        }
        return alarmDAO.deleteById(id) > 0;
    }

    @Override
    public boolean update(Long id, AlarmPutParamVO param) {
        AlarmDO alarmDO = new AlarmDO();
        alarmDO.setId(id);
        alarmDO.setCode(param.getCode());
        alarmDO.setGroups(param.getGroups());
        alarmDO.setName(param.getName());
        alarmDO.setExpression(param.getExpression());
        alarmDO.setDescription(param.getDescription());
        alarmDO.setStatus(AlarmStatus.fromValue(param.getStatus()));
        alarmDO.setRule(param.getRule());
        alarmDO.setIntervalSeconds(param.getIntervalSeconds());
        return alarmDAO.updateById(alarmDO) > 0;
    }

    @Override
    public boolean insert(AlarmInsertParamVO param) {
        AlarmDO alarm = alarmManager.getByCode(param.getGroups(), param.getCode());
        if (alarm != null) {
            throw new CommonException(ErrorCode.PARAM_ERROR, "groups和code组合出现重复！");
        }
        alarm = new AlarmDO();
        alarm.setCode(param.getCode());
        alarm.setGroups(param.getGroups());
        alarm.setName(param.getName());
        alarm.setExpression(param.getExpression());
        alarm.setDescription(param.getDescription());
        alarm.setStatus(AlarmStatus.OPEN);
        alarm.setRule(param.getRule());
        alarm.setIntervalSeconds(param.getIntervalSeconds());
        return alarmDAO.insert(alarm) > 0;
    }

    private AlarmVO convert(AlarmDO alarmDO) {
        AlarmVO vo = new AlarmVO();
        BeanUtils.copyProperties(alarmDO, vo);
        vo.setId(alarmDO.getId());
        vo.setStatus(alarmDO.getStatus().getValue());
        return vo;
    }
}
