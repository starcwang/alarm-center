package com.star.alarmcenter.model.vos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 报警查询参数
 *
 * @author wangchao
 * @date 2020/01/30
 */
@Getter
@Setter
@ToString
public class AlarmQueryParamVO {

    /** id */
    private Long id;
    /** 分组 */
    private String groups;
    /** 代码 */
    private String code;
    /** 名称 */
    private String name;
    /** 状态 */
    private Integer status;

    /** 页码 */
    private Integer pageNum;
    /** 页面大小 */
    private Integer pageSize;

}
