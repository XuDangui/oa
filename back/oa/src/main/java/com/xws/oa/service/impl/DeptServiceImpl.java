package com.xws.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.DeptMapper;
import com.xws.oa.entity.Dept;
import com.xws.oa.service.IDeptService;

@Service("deptService")
public class DeptServiceImpl implements IDeptService{
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return deptMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Dept record) {
		return deptMapper.insert(record);
	}

	@Override
	public int insertSelective(Dept record) {
		return deptMapper.insertSelective(record);
	}

	@Override
	public Dept selectByPrimaryKey(String id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Dept record) {
		return deptMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dept record) {
		return deptMapper.updateByPrimaryKey(record);
	}

}
