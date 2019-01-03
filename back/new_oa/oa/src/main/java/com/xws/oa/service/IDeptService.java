package com.xws.oa.service;

import java.util.List;

import com.xws.oa.entity.Dept;

public interface IDeptService {

	int deleteByPrimaryKey(String id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

	int deleteBatch(List<String> deptNoList);
	
	int selectCount();
}
