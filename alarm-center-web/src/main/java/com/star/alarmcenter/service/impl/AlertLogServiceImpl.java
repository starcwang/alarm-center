package com.star.alarmcenter.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.alarmcenter.dao.AlertLogDAO;
import com.star.alarmcenter.model.vos.AlertLogQueryParamVO;
import com.star.alarmcenter.model.vos.AlertLogVO;
import com.star.alarmcenter.model.vos.Paged;
import com.star.alarmcenter.service.AlertLogService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
 * @author wangchao
 * @date 2020/01/30
 */
@Service
public class AlertLogServiceImpl implements AlertLogService {

    @Resource
    private AlertLogDAO alertLogDAO;

    @Override
    public Paged<AlertLogVO> query(AlertLogQueryParamVO param) {
        Page<AlertLogVO> page = new Page<>(ObjectUtils.defaultIfNull(param.getPageNum(), 1),
            ObjectUtils.defaultIfNull(param.getPageSize(), 50));
        IPage<AlertLogVO> alertLogPage = alertLogDAO.query(page, param);
        return new Paged<>(alertLogPage.getTotal(), alertLogPage.getRecords());
    }
}
