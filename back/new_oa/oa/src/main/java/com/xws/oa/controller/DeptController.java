package com.xws.oa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.xws.oa.entity.Constant;
import com.xws.oa.entity.Dept;
import com.xws.oa.entity.ReturnMessBody;
import com.xws.oa.service.IDeptService;

/**
 * 部门表的基本操作，增删改查
 * @author xws
 *
 */
@Controller
@RequestMapping(value="/dept")
public class DeptController extends BaseController<Dept>{
	
	@Autowired
	private IDeptService deptService;
	
	/**
	 * 新增或修改
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/save", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object save(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String param) throws IOException{
		Gson gson = new Gson();
		Dept entity = gson.fromJson(param, Dept.class);
		int result = 0;
		String msg = null;
		result = deptService.insert(entity);
		//Dept deptEntity = deptService.selectByPrimaryKey(entity.getDeptNo());
		/*if(deptEntity != null ){
			result = deptService.updateByPrimaryKey(entity);
			msg = "修改成功";
		}if(entity != null && StringUtils.isEmpty(entity.getId())){
			entity.setCreateDate(new Date());
			result = deptService.insert(entity);
			msg = "新增成功";
		}*/
		if(result == 1){
			return new ReturnMessBody(Constant.SUCCESS, msg, entity);
		}
		return new ReturnMessBody(Constant.ERROR, "新增失败", "");
	}
	
	/**
	 * 查询部门列表接口
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/list", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object list(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String param) throws IOException{
		Gson gson = new Gson();
		Map<String,String> paramMap = gson.fromJson(param, Map.class);
		setPageHelper(paramMap);
		List<Dept> list = null;
		PageInfo<Dept> info = getPageInfo(list);
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", info);
	}
	
	/**
	 * 删除部门数据接口
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object delete(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String param) throws IOException{
		Gson gson = new Gson();
		Map<String,String> paramMap = gson.fromJson(param, Map.class);
		String[] deptNos = paramMap.get("deptNos").split(",");
		List<String> deptNoList = new ArrayList<String>();
		for(String deptNo : deptNos){
			deptNoList.add(deptNo);
		}
		int result = 0;
		try {
			result = deptService.deleteBatch(deptNoList);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "删除失败", result);
		}
		return new ReturnMessBody(Constant.SUCCESS, "删除成功", result);
	}

}
