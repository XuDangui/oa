package com.xws.oa.service;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.Role;
import com.xws.oa.entity.RoleKey;

public interface IRoleService {
	
	int deleteByPrimaryKey(RoleKey key);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(RoleKey key);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	List<Role> selectList(Map<String, String> param);

	int deleteBatch(List<String> idList);

}
