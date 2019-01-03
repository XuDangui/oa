package com.xws.oa.service;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.Account;

public interface IAccountService {
	
	int deleteByPrimaryKey(String account);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    List<Account> selectList(Map<String,String> param);
    
    int deleteBatch(List<String> list);

}
