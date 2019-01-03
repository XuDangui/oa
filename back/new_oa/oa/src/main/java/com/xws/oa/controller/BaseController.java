package com.xws.oa.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * controller基类，主要负责列表的分页查询的工具作为共用的函数调用
 * @author xws
 *
 * @param <T>
 */
public class BaseController<T>{
	
	/**
	 * 查询列表数据前，设置分页参数，页码和分页大小数值
	 * @param param
	 */
	public void setPageHelper(Map<String,String> param){
		int pageNum = StringUtils.isNotEmpty(param.get("pageNum")) ? Integer.valueOf(param.get("pageNum")) : 1;
		int pageSize = StringUtils.isNotEmpty(param.get("pageSize")) ? Integer.valueOf(param.get("pageSize")) : 10;
		PageHelper.startPage(pageNum, pageSize);
	}
	
	/**
	 * 将查询到的分页数据组装，带有分页信息返回前端
	 * @param list
	 * @return
	 */
	public PageInfo<T> getPageInfo(List<T> list){
		PageInfo<T> info = new PageInfo<T>(list);
		if(null != list && list.size() > 0){
			info.setList(list);
		}
		return info;
	}

}
