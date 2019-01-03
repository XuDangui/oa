package com.xws.oa.dao;

import java.util.List;

import com.xws.oa.entity.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(String deptNo);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String deptNo);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

	int deleteBatch(List<String> deptNoList);
	
	int selectCount();
}