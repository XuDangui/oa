package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.AuthorizationMapper;
import com.xws.oa.entity.Authorization;
import com.xws.oa.service.IAuthorizationService;

@Service("authorizationService")
public class AuthorizationServiceImpl implements IAuthorizationService{
	
	@Autowired
	private AuthorizationMapper authorizationMapper;

	@Override
	public int deleteByPrimaryKey(String authorizationNo) {
		
		return authorizationMapper.deleteByPrimaryKey(authorizationNo);
	}

	@Override
	public int insert(Authorization record) {
		
		return authorizationMapper.insert(record);
	}

	@Override
	public int insertSelective(Authorization record) {
		
		return authorizationMapper.insertSelective(record);
	}

	@Override
	public Authorization selectByPrimaryKey(String authorizationNo) {
		
		return authorizationMapper.selectByPrimaryKey(authorizationNo);
	}

	@Override
	public int updateByPrimaryKeySelective(Authorization record) {
		
		return authorizationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Authorization record) {
		
		return authorizationMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Authorization> selectList(Map<String, String> param) {
		return authorizationMapper.selectList(param);
	}

	@Override
	public int deleteBatch(List<String> idList) {
		return authorizationMapper.deleteBatch(idList);
	}

}
