package com.ccbjb.controller.permission;

import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.model.permission.SysPermissionModel;
import com.ccbjb.service.permission.IPermissionService;
import com.ccbjb.service.permission.IRoleService;
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
 * 用户权限分配
 */
@RestController
@Scope(value="prototype")
@RequestMapping("permission")
public class PermissionAllocationController extends BaseController {
	
	@Autowired
    IPermissionService permissionService;
	@Autowired
    IRoleService roleService;
	/**
	 * 权限分配
	 * @param pageNo
	 * @param findContent
	 * @return
	 */
	@PostMapping(value="allocation")
	public Result allocation(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return roleService.findRoleAndPermissionPage(map,pageNo,pageSize);
	}
	
	/**
	 * 根据角色ID查询权限
	 * @param id
	 * @return
	 */
	@GetMapping(value="selectPermissionById")
	public Result selectPermissionById(Long id){
		List<SysPermissionModel> permissionBos = permissionService.selectPermissionById(id);
		return ResultGenerator.genSuccessResult(permissionBos);
	}
	/**
	 * 操作角色的权限
	 * @param roleId 	角色ID
	 * @param ids		权限ID，以‘,’间隔
	 * @return
	 */
	@PostMapping(value="addPermission2Role")
	public Result addPermission2Role(Long roleId, Long[] ids){
		return permissionService.addPermission2Role(roleId,ids);
	}
	/**
	 * 根据角色id清空权限。
	 * @param roleIds	角色ID ，以‘,’间隔
	 * @return
	 */
	@PostMapping(value="clearPermissionByRoleIds")
	public Result clearPermissionByRoleIds(Long[] roleIds){
		return permissionService.deleteByRids(roleIds);
	}
}
