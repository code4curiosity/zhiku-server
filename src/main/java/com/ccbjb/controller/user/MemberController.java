package com.ccbjb.controller.user;

import com.ccbjb.common.mybatis.Result;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户会员管理
 */
@RestController
@Scope(value="prototype")
@RequestMapping("member")
public class MemberController extends BaseController{
	@Autowired
    IUserService userService;
	/**
	 * 用户列表管理
	 * @return
	 */
	@PostMapping(value="list")
	public Result list(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return userService.findByPage(map,pageNo,pageSize);
	}
	/**
	 * 根据ID删除，
	 * @param ids	如果有多个，以“,”间隔。
	 * @return
	 */
	@PostMapping(value="deleteUserById")
	public Result deleteUserById(Long[] ids){
		return userService.deleteUserById(ids);
	}
	/**
	 * 禁止登录
	 * @param id		用户ID
	 * @param status	1:有效，0:禁止登录
	 * @return
	 */
	@PostMapping(value="forbidUserById")
	public Result forbidUserById(Long id, Long status){
		return userService.updateForbidUserById(id,status);
	}
	
}
