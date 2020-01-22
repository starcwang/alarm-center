package com.star.alarmcenter.model.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 基础DO
 *
 * @author wangchao
 * @date 2020/01/21
 */
@Getter
@Setter
@ToString
public abstract class BaseDO<T> {

    /** 主键标识 */
    @TableId(type = IdType.AUTO)
    private T id;
    /** 创建时间 */
    private Date gmtCreate;
    /** 修改时间 */
    private Date gmtModified;

}
