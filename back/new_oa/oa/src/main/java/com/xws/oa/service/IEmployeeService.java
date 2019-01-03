package com.xws.oa.service;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.Employee;

public interface IEmployeeService {
	
	int deleteByPrimaryKey(String empNo);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empNo);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

	List<Employee> selectList(Map<String, String> param);

	int deleteBatch(List<String> idList);

}
