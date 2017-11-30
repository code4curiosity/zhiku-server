package com.ccbjb.service.permission;

import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.model.permission.SysPermissionModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IPermissionService {

	void deleteByPrimaryKey(Long id);

	SysPermission insert(SysPermission record);

	SysPermission insertSelective(SysPermission record);

	SysPermission selectByPrimaryKey(Long id);

    void updateByPrimaryKeySelective(SysPermission record);

    void updateByPrimaryKey(SysPermission record);

	Result deletePermissionById(Long[] ids);

	Result findPage(Map<String, String> resultMap, Integer pageNo,
                    Integer pageSize);
	List<SysPermissionModel> selectPermissionById(Long id);

	Result addPermission2Role(Long roleId, Long[] ids);

	Result deleteByRids(Long[] roleIds);
	//根据用户ID查询权限（permission），放入到Authorization里。
	Set<String> findPermissionByUserId(Long userId);
}
