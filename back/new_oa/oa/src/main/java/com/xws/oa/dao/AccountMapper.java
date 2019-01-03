package com.xws.oa.dao;

import com.xws.oa.entity.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(String account);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}