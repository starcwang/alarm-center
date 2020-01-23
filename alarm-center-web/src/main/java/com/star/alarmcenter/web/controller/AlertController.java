package com.star.alarmcenter.web.controller;

import com.star.alarmcenter.model.vos.AlertPointParamVO;
import com.star.alarmcenter.model.vos.Result;
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

    @PostMapping(value = "/point")
    public Result<Void> point(@RequestBody AlertPointParamVO param) {
        // TODO: 2020/1/23
        return Result.success();
    }
}
