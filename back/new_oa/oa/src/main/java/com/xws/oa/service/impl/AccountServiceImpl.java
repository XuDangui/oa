package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.AccountMapper;
import com.xws.oa.entity.Account;
import com.xws.oa.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public int deleteByPrimaryKey(String account) {
		
		return accountMapper.deleteByPrimaryKey(account);
	}

	@Override
	public int insert(Account record) {
		
		return accountMapper.insert(record);
	}

	@Override
	public int insertSelective(Account record) {
		
		return accountMapper.insertSelective(record);
	}

	@Override
	public Account selectByPrimaryKey(String account) {
		
		return accountMapper.selectByPrimaryKey(account);
	}

	@Override
	public int updateByPrimaryKeySelective(Account record) {
		
		return accountMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Account record) {
		
		return accountMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Account> selectList(Map<String, String> param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return 0;
	}

}
