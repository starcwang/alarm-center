package com.star.alarmcenter.model.vos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangchao
 * @date 2020/01/23
 */
@Getter
@Setter
@ToString
public class AlertPointParamVO {

    /** 代码 */
    private String code;
    /** 位置 */
    private String locate;
    /** 消息 */
    private String message;
    /** 堆栈跟踪列表 */
    private List<String> stackTraceList;

}
