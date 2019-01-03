package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.EvectionMapper;
import com.xws.oa.entity.Evection;
import com.xws.oa.service.IEvectionService;

@Service("evectionService")
public class EvectionServiceImpl implements IEvectionService{
	
	@Autowired
	private EvectionMapper evectionMapper;

	@Override
	public int deleteByPrimaryKey(String evectionNo) {
		
		return evectionMapper.deleteByPrimaryKey(evectionNo);
	}

	@Override
	public int insert(Evection record) {
		
		return evectionMapper.insert(record);
	}

	@Override
	public int insertSelective(Evection record) {
		
		return evectionMapper.insertSelective(record);
	}

	@Override
	public Evection selectByPrimaryKey(String evectionNo) {
		
		return evectionMapper.selectByPrimaryKey(evectionNo);
	}

	@Override
	public int updateByPrimaryKeySelective(Evection record) {
		
		return evectionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Evection record) {
		
		return evectionMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Evection> selectList(Map<String, String> param) {
		return evectionMapper.selectList(param);
	}

	@Override
	public int deleteBatch(List<String> idList) {
		return evectionMapper.deleteBatch(idList);
	}

}
