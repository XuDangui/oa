package com.xws.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xws.oa.entity.Tuser;
import com.xws.oa.service.ITuserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/tuser")
public class TuserController {
	
	@Autowired
	private ITuserService tuserService;
	
	@RequestMapping(value ="/loginInfo", method = RequestMethod.GET)
	@ResponseBody
	public void LoginInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
	    Tuser user = tuserService.selectByPrimaryKey(1);
	    JSONObject json = JSONObject.fromObject(user);
	    PrintWriter out = response.getWriter();
	    out.print(json);
	    out.close();
	}

}
