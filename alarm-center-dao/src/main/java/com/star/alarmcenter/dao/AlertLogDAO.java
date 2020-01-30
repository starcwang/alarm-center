package com.star.alarmcenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.alarmcenter.model.dos.AlertLogDO;
import com.star.alarmcenter.model.vos.AlertLogQueryParamVO;
import com.star.alarmcenter.model.vos.AlertLogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * alert_log
 *
 * @author wangchao
 * @date 2020/01/28
 */
@Mapper
@Repository
public interface AlertLogDAO extends BaseMapper<AlertLogDO> {

    /**
     * 查询
     *
     * @param page 页面
     * @param param 参数
     * @return {@link IPage<AlertLogVO>}
     */
    IPage<AlertLogVO> query(Page<AlertLogVO> page, @Param("param") AlertLogQueryParamVO param);
}
