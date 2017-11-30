package com.ccbjb.controller.permission;

import com.ccbjb.common.domain.SysRole;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
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
 * 用户角色管理
 */
@RestController
@Scope(value="prototype")
@RequestMapping("role")
public class RoleController extends BaseController {
	@Autowired
    IRoleService roleService;
	/**
	 * 角色列表
	 * @return
	 */
	@PostMapping(value="index")
	public Result index(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return roleService.findPage(map,pageNo,pageSize);
	}
	/**
	 * 角色添加
	 * @param role
	 * @return
	 */
	@PostMapping(value="addRole")
	public Result addRole(SysRole role){
		Result result = null;
		try {
			roleService.insertSelective(role);
			result = ResultGenerator.genSuccessResult("添加成功");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
			LoggerUtils.fmtError(getClass(), e, "添加角色报错。source[%s]",role.toString());
		}
		return result;
	}
	/**
	 * 删除角色，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
	 * @param ids
	 * @return
	 */
	@PostMapping(value="deleteRoleById")
	public Result deleteRoleById(Long[] ids){
		return roleService.deleteRoleById(ids);
	}
	/**
	 * 我的权限
	 * @return
	 */
	@GetMapping(value="getPermissionTree")
	public Result getPermissionTree(){
		//查询我所有的角色 ---> 权限
		List<SysRole> roles = roleService.findNowAllPermission();
		//把查询出来的roles 转换成bootstarp 的 tree数据
		return ResultGenerator.genSuccessResult(roles);
	}
}
