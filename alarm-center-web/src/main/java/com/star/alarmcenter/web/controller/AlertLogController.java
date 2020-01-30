package com.star.alarmcenter.web.controller;

import javax.annotation.Resource;

import com.star.alarmcenter.model.vos.AlertLogQueryParamVO;
import com.star.alarmcenter.model.vos.AlertLogVO;
import com.star.alarmcenter.model.vos.Paged;
import com.star.alarmcenter.model.vos.Result;
import com.star.alarmcenter.service.AlertLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@RestController
@RequestMapping("/alertLog")
public class AlertLogController {

    @Resource
    private AlertLogService alertLogService;

    @PostMapping("/query")
    public Result<Paged<AlertLogVO>> query(@RequestBody AlertLogQueryParamVO param) {
        return Result.success(alertLogService.query(param));
    }
}
