package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.RoleMapper;
import com.xws.oa.entity.Role;
import com.xws.oa.entity.RoleKey;
import com.xws.oa.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public int deleteByPrimaryKey(RoleKey key) {
		
		return roleMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Role record) {
		
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(RoleKey key) {
		
		return roleMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> selectList(Map<String, String> param) {
		return roleMapper.selectList(param);
	}

	@Override
	public int deleteBatch(List<String> idList) {
		return roleMapper.deleteBatch(idList);
	}

}
