package com.xws.oa.service;

import com.xws.oa.entity.Tuser;

public interface ITuserService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    Tuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);

}
