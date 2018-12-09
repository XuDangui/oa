package com.xws.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.TuserMapper;
import com.xws.oa.entity.Tuser;
import com.xws.oa.service.ITuserService;

@Service("tuserService")
public class TuserServiceImpl implements ITuserService{
	
	@Autowired
	private TuserMapper tuserMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(Tuser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Tuser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tuser selectByPrimaryKey(Integer id) {
		
		return tuserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Tuser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Tuser record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
