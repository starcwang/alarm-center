package com.star.alarmcenter.model.dos;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基础DO
 *
 * @author wangchao
 * @date 2020/01/21
 */
@Getter
@Setter
@ToString
public abstract class BaseDO {

    /** 主键标识 */
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 创建时间 */
    private Date gmtCreate;
    /** 修改时间 */
    private Date gmtModified;

    /** 常量 */
    public static final String CONST_ID = "id";
    public static final String CONST_GMT_CREATE = "gmtCreate";
    public static final String CONST_GMT_MODIFIED = "gmtModified";
}
