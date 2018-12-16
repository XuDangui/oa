package com.xws.oa.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xws.oa.entity.Constant;
import com.xws.oa.entity.Dept;
import com.xws.oa.entity.ReturnMessBody;
import com.xws.oa.entity.User;
import com.xws.oa.service.IDeptService;

@Controller
@RequestMapping(value="/dept")
public class DeptController {
	
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping(value ="/add", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object add(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String param) throws IOException{
		Gson gson = new Gson();
		Dept entity = gson.fromJson(param, Dept.class);
		int result = deptService.insert(entity);
		if(result == 1){
			return new ReturnMessBody(Constant.SUCCESS, "新增成功", entity);
		}
		return new ReturnMessBody(Constant.ERROR, "新增失败", "");
	}

}
