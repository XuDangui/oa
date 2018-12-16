package com.xws.oa.service;

import com.xws.oa.entity.User;

public interface IUserService {
	
	int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByAccount(String account);

}
