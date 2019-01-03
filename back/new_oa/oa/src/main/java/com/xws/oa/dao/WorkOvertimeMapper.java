package com.xws.oa.dao;

import java.util.List;
import java.util.Map;

import com.xws.oa.entity.WorkOvertime;

public interface WorkOvertimeMapper {
    int deleteByPrimaryKey(String overNo);

    int insert(WorkOvertime record);

    int insertSelective(WorkOvertime record);

    WorkOvertime selectByPrimaryKey(String overNo);

    int updateByPrimaryKeySelective(WorkOvertime record);

    int updateByPrimaryKey(WorkOvertime record);

	List<WorkOvertime> selectList(Map<String, String> param);

	int deleteBatch(List<String> idList);
}