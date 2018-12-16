package com.xws.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;
import com.xws.oa.entity.Constant;
import com.xws.oa.entity.ReturnMessBody;
import com.xws.oa.entity.User;
import com.xws.oa.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value ="/login", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object LoginInfo(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String param) throws IOException{
		Gson gson = new Gson();
		User entity = gson.fromJson(param, User.class);
		if(entity == null 
				|| StringUtils.isEmpty(entity.getAccount())
				|| StringUtils.isEmpty(entity.getPassword())){
			return new ReturnMessBody(Constant.ERROR, "账号或密码为空", "");
		}
		User user = userService.selectByAccount(entity.getAccount());
		if(user!=null && entity.getPassword().equals(user.getPassword())){
			return new ReturnMessBody(Constant.SUCCESS, "登录成功", user);
		}else{
			return new ReturnMessBody(Constant.ERROR, "账号或密码错误，登录失败", "");
		}
	}

}
