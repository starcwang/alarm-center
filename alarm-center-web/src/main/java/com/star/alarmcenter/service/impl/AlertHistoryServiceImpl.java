package com.star.alarmcenter.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.alarmcenter.dao.AlertHistoryDAO;
import com.star.alarmcenter.model.vos.AlertHistoryQueryParamVO;
import com.star.alarmcenter.model.vos.AlertHistoryVO;
import com.star.alarmcenter.model.vos.Paged;
import com.star.alarmcenter.service.AlertHistoryService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
 * @author wangchao
 * @date 2020/01/30
 */
@Service
public class AlertHistoryServiceImpl implements AlertHistoryService {


    @Resource
    private AlertHistoryDAO alertHistoryDAO;

    @Override
    public Paged<AlertHistoryVO> query(AlertHistoryQueryParamVO param) {
        Page<AlertHistoryVO> page = new Page<>(ObjectUtils.defaultIfNull(param.getPageNum(), 1),
            ObjectUtils.defaultIfNull(param.getPageSize(), 50));
        IPage<AlertHistoryVO> alertHistoryPage = alertHistoryDAO.query(page, param);
        return new Paged<>(alertHistoryPage.getTotal(), param.getPageNum(), param.getPageSize(), alertHistoryPage.getRecords());
    }
}
