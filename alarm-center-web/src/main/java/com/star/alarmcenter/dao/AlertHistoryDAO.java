package com.star.alarmcenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.alarmcenter.model.dos.AlertHistoryDO;
import com.star.alarmcenter.model.vos.AlertHistoryQueryParamVO;
import com.star.alarmcenter.model.vos.AlertHistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * alert_history
 *
 * @author wangchao
 * @date 2020/01/23
 */
@Mapper
@Repository
public interface AlertHistoryDAO extends BaseMapper<AlertHistoryDO> {

    /**
     * 查询
     *
     * @param page 页面
     * @param param 参数
     * @return {@link IPage<AlertHistoryVO>}
     */
    IPage<AlertHistoryVO> query(Page<AlertHistoryVO> page, @Param("param") AlertHistoryQueryParamVO param);
}
