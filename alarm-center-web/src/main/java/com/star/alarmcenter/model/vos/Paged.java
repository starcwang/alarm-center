package com.star.alarmcenter.model.vos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangchao
 * @date 2020/01/30
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Paged<T> {
    /** 总计 */
    private long total;
    /** 页码 */
    private int pageNum;
    /** 页面大小 */
    private int pageSize;
    /** 数据 */
    private List<T> data;
}
