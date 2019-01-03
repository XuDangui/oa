package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.WorkOvertimeMapper;
import com.xws.oa.entity.WorkOvertime;
import com.xws.oa.service.IWorkOvertimeService;

@Service("IWorkOvertimeService")
public class WorkOvertimeServiceImpl implements IWorkOvertimeService{
	
	@Autowired
	private WorkOvertimeMapper workOvertimeMapper;

	@Override
	public int deleteByPrimaryKey(String overNo) {
		
		return workOvertimeMapper.deleteByPrimaryKey(overNo);
	}

	@Override
	public int insert(WorkOvertime record) {
		
		return workOvertimeMapper.insert(record);
	}

	@Override
	public int insertSelective(WorkOvertime record) {
		
		return workOvertimeMapper.insertSelective(record);
	}

	@Override
	public WorkOvertime selectByPrimaryKey(String overNo) {
		
		return workOvertimeMapper.selectByPrimaryKey(overNo);
	}

	@Override
	public int updateByPrimaryKeySelective(WorkOvertime record) {
		
		return workOvertimeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WorkOvertime record) {
		
		return workOvertimeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<WorkOvertime> selectList(Map<String, String> param) {
		return workOvertimeMapper.selectList(param);
	}

	@Override
	public int deleteBatch(List<String> idList) {
		return workOvertimeMapper.deleteBatch(idList);
	}

}
