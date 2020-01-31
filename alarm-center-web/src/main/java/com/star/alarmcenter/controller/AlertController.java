package com.star.alarmcenter.controller;

import javax.annotation.Resource;

import com.star.alarmcenter.model.vos.AlertLogParamVO;
import com.star.alarmcenter.model.vos.Result;
import com.star.alarmcenter.service.AlertService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@RestController
@RequestMapping("/alert")
public class AlertController {

    @Resource
    private AlertService alertService;

    @PostMapping(value = "/log")
    public Result<Void> log(@RequestBody AlertLogParamVO param) {
        alertService.log(param);
        return Result.success();
    }
}
