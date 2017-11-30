package com.ccbjb.controller.permission;

import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.permission.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户权限管理
 */
@RestController
@Scope(value="prototype")
@RequestMapping("permission")
public class PermissionController extends BaseController{
	
	@Autowired
    IPermissionService permissionService;
	/**
	 * 权限列表
	 * @param findContent	查询内容
	 * @param pageNo		页码
	 * @return
	 */
	@PostMapping(value="index")
	public Result index(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return permissionService.findPage(map,pageNo,pageSize);
	}
	/**
	 * 权限添加
	 * @param psermission
	 * @return
	 */
	@PostMapping(value="addPermission")
	public Result addPermission(SysPermission psermission){
		Result result = null;
		try {
			SysPermission entity = permissionService.insertSelective(psermission);
			result = ResultGenerator.genSuccessResult("权限添加成功");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
			LoggerUtils.fmtError(getClass(), e, "添加权限报错。source[%s]", psermission.toString());
		}
		return result;
	}
	/**
	 * 删除权限，根据ID，但是删除权限的时候，需要查询是否有赋予给角色，如果有角色在使用，那么就不能删除。
	 * @param ids
	 * @return
	 */
	@PostMapping(value="deletePermissionById")
	public Result deletePermissionById(Long[] ids){
		return permissionService.deletePermissionById(ids);
	}
}
