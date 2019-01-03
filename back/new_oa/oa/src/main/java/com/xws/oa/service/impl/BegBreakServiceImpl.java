package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;

import com.xws.oa.dao.BegBreakMapper;
import com.xws.oa.entity.BegBreak;
import com.xws.oa.service.IBegBreakService;

public class BegBreakServiceImpl implements IBegBreakService{
	
	private static final AtomicInteger atomicNum = new AtomicInteger();
	
	private static final String RULE = "QJSQ";
	
	private static final int MAX_SERIAL_NUM = 0;
	
	@Autowired
	private BegBreakMapper begBreakMapper;

	@Override
	public int deleteByPrimaryKey(String begNo) {
		
		return begBreakMapper.deleteByPrimaryKey(begNo);
	}

	@Override
	public int insert(BegBreak record) {
		
		return begBreakMapper.insert(record);
	}

	@Override
	public int insertSelective(BegBreak record) {
		
		return begBreakMapper.insertSelective(record);
	}

	@Override
	public BegBreak selectByPrimaryKey(String begNo) {
		
		return begBreakMapper.selectByPrimaryKey(begNo);
	}

	@Override
	public int updateByPrimaryKeySelective(BegBreak record) {
		
		return begBreakMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BegBreak record) {
		
		return begBreakMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<BegBreak> selectList(Map<String, String> param) {
		return begBreakMapper.selectList(param);
	}

	@Override
	public int deleteBatch(List<String> idList) {
		return begBreakMapper.deleteBatch(idList);
	}

}
