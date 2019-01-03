package com.xws.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.DeptMapper;
import com.xws.oa.entity.Dept;
import com.xws.oa.service.IDeptService;

@Service("deptService")
public class DeptServiceImpl implements IDeptService{
	
	private static final AtomicInteger atomicNum = new AtomicInteger();
	
	private static final String RULE = "BM";
	
	private static final int MAX_SERIAL_NUM = 0;
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return deptMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Dept record) {
		int serialNum = atomicNum.getAndIncrement();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateFormat = sdf.format(date).replaceAll("-", "");
		String deptNo = RULE +"-"+ dateFormat +"-"+ String.format("%04d", serialNum);
		record.setDeptNo(deptNo);
		return deptMapper.insert(record);
	}

	@Override
	public int insertSelective(Dept record) {
		return deptMapper.insertSelective(record);
	}

	@Override
	public Dept selectByPrimaryKey(String id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Dept record) {
		return deptMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dept record) {
		return deptMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteBatch(List<String> deptNoList) {
		return deptMapper.deleteBatch(deptNoList);
	}
	
	@PostConstruct
	private void initMaxNum(){
		int maxNum = deptMapper.selectCount();
		if(maxNum < MAX_SERIAL_NUM){
			maxNum = MAX_SERIAL_NUM;
		}
		atomicNum.set(maxNum);
	}

	@Override
	public int selectCount() {
		return deptMapper.selectCount();
	}

}
