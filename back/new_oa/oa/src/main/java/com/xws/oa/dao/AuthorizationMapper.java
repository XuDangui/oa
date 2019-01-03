package com.xws.oa.dao;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.Authorization;

public interface AuthorizationMapper {
    int deleteByPrimaryKey(String authorizationNo);

    int insert(Authorization record);

    int insertSelective(Authorization record);

    Authorization selectByPrimaryKey(String authorizationNo);

    int updateByPrimaryKeySelective(Authorization record);

    int updateByPrimaryKey(Authorization record);

	List<Authorization> selectList(Map<String, String> param);

	int deleteBatch(List<String> idList);
}