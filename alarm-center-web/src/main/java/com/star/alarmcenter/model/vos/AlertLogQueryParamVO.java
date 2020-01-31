package com.star.alarmcenter.model.vos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangchao
 * @date 2020/01/30
 */
@Getter
@Setter
@ToString
public class AlertLogQueryParamVO {

    /** id */
    private Long id;
    /** 分组 */
    private String groups;
    /** 代码 */
    private String code;
    /** 名称 */
    private String name;

    /** 开始时间 */
    private Date startTime;
    /** 结束时间 */
    private Date endTime;

    /** 页码 */
    private Integer pageNum;
    /** 页面大小 */
    private Integer pageSize;

}
