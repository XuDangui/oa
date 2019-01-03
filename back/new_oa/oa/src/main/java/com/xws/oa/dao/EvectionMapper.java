package com.xws.oa.dao;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.Evection;

public interface EvectionMapper {
    int deleteByPrimaryKey(String evectionNo);

    int insert(Evection record);

    int insertSelective(Evection record);

    Evection selectByPrimaryKey(String evectionNo);

    int updateByPrimaryKeySelective(Evection record);

    int updateByPrimaryKey(Evection record);

	List<Evection> selectList(Map<String, String> param);

	int deleteBatch(List<String> idList);
}