package com.star.alarmcenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.alarmcenter.model.dos.AlarmDO;
import com.star.alarmcenter.model.vos.AlarmQueryParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * alarm
 *
 * @author wangchao
 * @date 2020/01/23
 */
@Mapper
@Repository
public interface AlarmDAO extends BaseMapper<AlarmDO> {

    /**
     * 查询
     *
     * @param page 页面
     * @param param 参数
     * @return {@link IPage<AlarmDO>}
     */
    IPage<AlarmDO> query(Page<AlarmDO> page, @Param("param") AlarmQueryParamVO param);
}
