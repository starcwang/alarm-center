package com.star.alarmcenter.controller;

import javax.annotation.Resource;

import com.star.alarmcenter.model.vos.AlarmInsertParamVO;
import com.star.alarmcenter.model.vos.AlarmPutParamVO;
import com.star.alarmcenter.model.vos.AlarmQueryParamVO;
import com.star.alarmcenter.model.vos.AlarmVO;
import com.star.alarmcenter.model.vos.Paged;
import com.star.alarmcenter.model.vos.Result;
import com.star.alarmcenter.service.AlarmService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@RestController
@RequestMapping("/alarm")
public class AlarmController {

    @Resource
    private AlarmService alarmService;

    @GetMapping("/{id}")
    public Result<AlarmVO> get(@PathVariable Long id) {
        return Result.success(alarmService.get(id));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(alarmService.delete(id));
    }

    @PutMapping("/insert")
    public Result<Boolean> insert(@RequestBody AlarmInsertParamVO param) {
        return Result.success(alarmService.insert(param));
    }

    @PutMapping("/{id}")
    public Result<Boolean> put(@PathVariable Long id, @RequestBody AlarmPutParamVO param) {
        return Result.success(alarmService.update(id, param));
    }

    @PostMapping("/query")
    public Result<Paged<AlarmVO>> query(@RequestParam String aaa, @RequestBody AlarmQueryParamVO param) {
        return Result.success(alarmService.query(param));
    }
}
