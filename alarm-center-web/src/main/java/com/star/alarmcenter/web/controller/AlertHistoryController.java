package com.star.alarmcenter.web.controller;

import javax.annotation.Resource;

import com.star.alarmcenter.model.vos.AlertHistoryQueryParamVO;
import com.star.alarmcenter.model.vos.AlertHistoryVO;
import com.star.alarmcenter.model.vos.Paged;
import com.star.alarmcenter.model.vos.Result;
import com.star.alarmcenter.service.AlertHistoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@RestController
@RequestMapping("/alertHistory")
public class AlertHistoryController {

    @Resource
    private AlertHistoryService alertHistoryService;

    @PostMapping("/query")
    public Result<Paged<AlertHistoryVO>> query(@RequestBody AlertHistoryQueryParamVO param) {
        return Result.success(alertHistoryService.query(param));
    }
}
