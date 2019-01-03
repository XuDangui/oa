package com.xws.oa.dao;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.BegBreak;

public interface BegBreakMapper {
    int deleteByPrimaryKey(String begNo);

    int insert(BegBreak record);

    int insertSelective(BegBreak record);

    BegBreak selectByPrimaryKey(String begNo);

    int updateByPrimaryKeySelective(BegBreak record);

    int updateByPrimaryKey(BegBreak record);

	List<BegBreak> selectList(Map<String, String> param);

	int deleteBatch(List<String> idList);
}