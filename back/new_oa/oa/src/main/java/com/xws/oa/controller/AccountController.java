package com.xws.oa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.xws.oa.entity.Account;
import com.xws.oa.entity.Constant;
import com.xws.oa.entity.ReturnMessBody;
import com.xws.oa.service.IAccountService;

/**
 * 账号相关操作，增删改查
 * @author xws
 *
 */
@Controller
@RequestMapping(value="/account")
public class AccountController extends BaseController<Account>{
	
	@Autowired
	private IAccountService accountService;
	
	/**
	 * 新建或保存修改的接口
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
		Account entity = gson.fromJson(param, Account.class);
		Account accountEntity = accountService.selectByPrimaryKey(entity.getAccount());
		String msg = null;
		int result = 0;
		if(null != accountEntity){
			result = accountService.updateByPrimaryKey(entity);
			msg = "修改成功";
		}else{
			result = accountService.insert(entity);
			msg = "新增成功";
		}
		
		if(result == 1){
			return new ReturnMessBody(Constant.SUCCESS, msg, entity);
		}
		msg="新增或修改失败";
		return new ReturnMessBody(Constant.ERROR, msg, "");
	}
	
	/**
	 * 登录验证
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/login", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object login(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String param) throws IOException{
		Gson gson = new Gson();
		Account entity = gson.fromJson(param, Account.class);
		Account result = accountService.selectByPrimaryKey(entity.getAccount());
		if(StringUtils.isNotEmpty(entity.getPassword())
				&& entity.getPassword().equals(result.getPassword())){
			return new ReturnMessBody(Constant.SUCCESS, "登录成功", entity);
		}
		return new ReturnMessBody(Constant.ERROR, "登录失败", "");
	}
	
	/**
	 * 查询账号列表数据接口
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
		List<Account> list = null;
		try {
			list = accountService.selectList(param);
		} catch (Exception e) {
			return new ReturnMessBody(Constant.ERROR, "查询失败", null);
		}
		PageInfo<Account> pageInfo = getPageInfo(list);
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
		List<String> idList = new ArrayList<String>(Arrays.asList(idArr));
		int result = 0;
		try {
			result = accountService.deleteBatch(idList);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "删除失败", e.getMessage());
		}
		return new ReturnMessBody(Constant.SUCCESS, "删除成功", result);
	}
	
	/**
	 * 查询单条记录数据
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
		Account account = null;
		try {
			account = accountService.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMessBody(Constant.ERROR, "查询失败", e.getMessage());
		}
		return new ReturnMessBody(Constant.SUCCESS, "查询成功", account);
	}

}
