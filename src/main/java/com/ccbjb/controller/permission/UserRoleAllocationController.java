package com.ccbjb.controller.permission;

import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.model.permission.SysRoleModel;
import com.ccbjb.service.permission.IPermissionService;
import com.ccbjb.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户角色分配
 */
@RestController
@Scope(value="prototype")
@RequestMapping("role")
public class UserRoleAllocationController extends BaseController {
	@Autowired
    IUserService userService;
	@Autowired
    IPermissionService permissionService;
	/**
	 * 用户角色权限分配
	 * @param pageNo
	 * @param findContent
	 * @return
	 */
	@PostMapping(value="allocation")
	public Result allocation(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return userService.findUserAndRole(map,pageNo,pageSize);
	}
	
	/**
	 * 根据用户ID查询权限
	 * @param id
	 * @return
	 */
	@GetMapping(value="selectRoleByUserId")
	public Result selectRoleByUserId(Long id){
		List<SysRoleModel> bos = userService.selectRoleByUserId(id);
		return ResultGenerator.genSuccessResult(bos);
	}
	/**
	 * 操作用户的角色
	 * @param userId 	用户ID
	 * @param ids		角色ID，以‘,’间隔
	 * @return
	 */
	@PostMapping(value="addRole2User")
	public Result addRole2User(Long userId, Long[] ids){
		return userService.addRole2User(userId,ids);
	}
	/**
	 * 根据用户id清空角色。
	 * @param userIds	用户ID ，以‘,’间隔
	 * @return
	 */
	@PostMapping(value="clearRoleByUserIds")
	public Result clearRoleByUserIds(Long[] userIds){
		return userService.deleteRoleByUserIds(userIds);
	}
}
