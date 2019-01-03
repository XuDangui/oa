package com.xws.oa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xws.oa.entity.Constant;
import com.xws.oa.entity.ReturnMessBody;
import com.xws.oa.entity.Role;
import com.xws.oa.service.IRoleService;

/**
 * 角色表的基本操作，增删改查
 * @author xws
 *
 */
@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController<Role>{
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value ="/save", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object save(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String param) throws IOException{
		
		return null;
	}
	
	
	@RequestMapping(value ="/list", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object list(HttpServletRequest request,
			HttpServletResponse response,@RequestBody Map<String,String> param) throws IOException{
		setPageHelper(param);
		List<Role> list = null;
		try {
			list = roleService.selectList(param);
		} catch (Exception e) {
			return new ReturnMessBody(Constant.ERROR, "查询失败", null);
		}
		PageInfo<Role> pageInfo = getPageInfo(list);
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", pageInfo);
	}
	
	@RequestMapping(value ="/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object delete(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String ids) throws IOException{
		String[] idArr = ids.split(",");
		List<String> idList = new ArrayList<String>(Arrays.asList(idArr));
		int result = 0;
		try {
			result = roleService.deleteBatch(idList);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "删除失败", e.getMessage());
		}
		return new ReturnMessBody(Constant.SUCCESS, "删除成功", result);
	}
	
	/**
	 * 角色单条数据查询接口
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/get", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object get(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String id) throws IOException{
		Role role = null;
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", role);
	}

}
