package com.miaozhen.mxd.mapper;

import com.miaozhen.mxd.entity.MzOperationLog;

public interface MzOperationLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MzOperationLog record);

    int insertSelective(MzOperationLog record);

    MzOperationLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MzOperationLog record);

    int updateByPrimaryKey(MzOperationLog record);
}