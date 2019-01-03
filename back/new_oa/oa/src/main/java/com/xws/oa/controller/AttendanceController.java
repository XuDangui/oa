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
import com.xws.oa.entity.Attendance;
import com.xws.oa.entity.Constant;
import com.xws.oa.entity.ReturnMessBody;
import com.xws.oa.service.IAttendanceService;

/**
 * 考勤表的相关操作，增删改查
 * @author xws
 *
 */
@Controller
@RequestMapping(value="/attendance")
public class AttendanceController extends BaseController<Attendance>{
	
	@Autowired
	private IAttendanceService attendanceService;
	
	/**
	 * 新增或修改保存接口
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
		Attendance attendance = null;
		String msg = null;
		try {
			Gson gson = new Gson();
			//将前端的数据转化为实体类
			attendance = gson.fromJson(param, Attendance.class);
			//查询数据库，判断是否有记录，有记录则只是更新数据
			Attendance entity = attendanceService.selectByPrimaryKey(attendance.getAttendanceNo());
			if(entity != null 
					&& entity.getAttendanceNo().equals(attendance.getAttendanceNo())){
				//更新
				attendanceService.updateByPrimaryKey(attendance);
				msg = "修改成功";
			}else{
				//新增
				attendanceService.insert(attendance);
				msg = "新增成功";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "保存失败", e.getMessage()); 
		}
		return new ReturnMessBody(Constant.SUCCESS, msg, attendance); 
	}
	
	/**
	 * 查询考勤列表数据
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
		PageInfo<Attendance> pageInfo = null;
		try {
			List<Attendance> list = attendanceService.selectList(param);
			pageInfo = getPageInfo(list);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "查询失败", e.getMessage()); 
		}
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", pageInfo);
	}
	
	/**
	 * 删除接口
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
		int result = 0;
		try {
			List<String> idList = new ArrayList<String>(Arrays.asList(idArr));
			result = attendanceService.deleteBatch(idList);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "删除失败", e.getMessage());
		}
		return new ReturnMessBody(Constant.SUCCESS, "删除成功", result);
	}
	
	/**
	 * 查询单条数据接口
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
		Attendance attendance = null;
		try {
			attendance = attendanceService.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "查询失败", e.getMessage());
		}
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", attendance);
	}

}
