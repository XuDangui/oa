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
import com.google.gson.Gson;
import com.xws.oa.entity.Constant;
import com.xws.oa.entity.ReturnMessBody;
import com.xws.oa.entity.WorkOvertime;
import com.xws.oa.service.IWorkOvertimeService;

/**
 * 加班表的基本操作，增删改查
 * @author xws
 *
 */
@Controller
@RequestMapping(value="/workOvertime")
public class WorkOvertimeController extends BaseController<WorkOvertime>{
	
	@Autowired
	private IWorkOvertimeService workOvertimeService;
	
	/**
	 * 加班新建和修改保存接口
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
		WorkOvertime entity = gson.fromJson(param, WorkOvertime.class);
		WorkOvertime workOvertimeEntity = workOvertimeService.selectByPrimaryKey(entity.getOverNo());
		String msg = null;
		int result = 0;
		if(null != workOvertimeEntity){
			result = workOvertimeService.updateByPrimaryKey(entity);
			msg = "修改成功";
		}else{
			result = workOvertimeService.insert(entity);
			msg = "新增成功";
		}
		
		if(result == 1){
			return new ReturnMessBody(Constant.SUCCESS, msg, entity);
		}
		msg="新增或修改失败";
		return new ReturnMessBody(Constant.ERROR, msg, "");
	}
	
	/**
	 * 加班列表查询接口
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/list", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object list(HttpServletRequest request,
			HttpServletResponse response,@RequestBody Map<String,String> param) throws IOException{
		setPageHelper(param);
		List<WorkOvertime> list = null;
		try {
			list = workOvertimeService.selectList(param);
		} catch (Exception e) {
			return new ReturnMessBody(Constant.ERROR, "查询失败", null);
		}
		PageInfo<WorkOvertime> pageInfo = getPageInfo(list);
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", pageInfo);
	}
	
	/**
	 * 加班删除接口
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object delete(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String ids) throws IOException{
		String[] idArr = ids.split(",");
		List<String> idList = new ArrayList<String>(Arrays.asList(idArr));
		int result = 0;
		try {
			result = workOvertimeService.deleteBatch(idList);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "删除失败", e.getMessage());
		}
		return new ReturnMessBody(Constant.SUCCESS, "删除成功", result);
	}
	
	/**
	 * 加班单条数据查询接口
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
		WorkOvertime workOvertime = null;
		try {
			workOvertime = workOvertimeService.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "查询失败", e.getMessage());
		}
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", workOvertime);
	}

}
