package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.EmployeeMapper;
import com.xws.oa.entity.Employee;
import com.xws.oa.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public int deleteByPrimaryKey(String empNo) {
		
		return employeeMapper.deleteByPrimaryKey(empNo);
	}

	@Override
	public int insert(Employee record) {
		
		return employeeMapper.insert(record);
	}

	@Override
	public int insertSelective(Employee record) {
		
		return employeeMapper.insertSelective(record);
	}

	@Override
	public Employee selectByPrimaryKey(String empNo) {
		
		return employeeMapper.selectByPrimaryKey(empNo);
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		
		return employeeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		
		return employeeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Employee> selectList(Map<String, String> param) {
		return employeeMapper.selectList(param);
	}

	@Override
	public int deleteBatch(List<String> idList) {
		return employeeMapper.deleteBatch(idList);
	}
	

}
