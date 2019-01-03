package com.xws.oa.service;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.Attendance;

public interface IAttendanceService {
	
	int deleteByPrimaryKey(String attendanceNo);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(String attendanceNo);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);

	List<Attendance> selectList(Map<String, String> param);

	int deleteBatch(List<String> idList);

}
