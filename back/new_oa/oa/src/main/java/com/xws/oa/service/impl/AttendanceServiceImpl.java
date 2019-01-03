package com.xws.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.oa.dao.AttendanceMapper;
import com.xws.oa.entity.Attendance;
import com.xws.oa.service.IAttendanceService;

@Service("attendanceService")
public class AttendanceServiceImpl implements IAttendanceService{
	
	@Autowired
	private AttendanceMapper attendanceMapper;

	@Override
	public int deleteByPrimaryKey(String attendanceNo) {
		
		return attendanceMapper.deleteByPrimaryKey(attendanceNo);
	}

	@Override
	public int insert(Attendance record) {
		
		return attendanceMapper.insert(record);
	}

	@Override
	public int insertSelective(Attendance record) {
		
		return attendanceMapper.insertSelective(record);
	}

	@Override
	public Attendance selectByPrimaryKey(String attendanceNo) {
		
		return attendanceMapper.selectByPrimaryKey(attendanceNo);
	}

	@Override
	public int updateByPrimaryKeySelective(Attendance record) {
		
		return attendanceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Attendance record) {
		
		return attendanceMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Attendance> selectList(Map<String, String> param) {
		
		return attendanceMapper.selectList(param);
	}

	@Override
	public int deleteBatch(List<String> idList) {
		
		return attendanceMapper.deleteBatch(idList);
	}

}
