package com.ccbjb.service.permission;

import com.ccbjb.common.domain.SysRole;
import com.ccbjb.common.mybatis.Result;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRoleService {

	void deleteByPrimaryKey(Long id);

    void insert(SysRole record);

    void insertSelective(SysRole record);

	SysRole selectByPrimaryKey(Long id);

    void updateByPrimaryKeySelective(SysRole record);

    void updateByPrimaryKey(SysRole record);

	Result findPage(Map<String, String> resultMap, Integer pageNo,
                    Integer pageSize);

	Result deleteRoleById(Long[] ids);

	Result findRoleAndPermissionPage(
            Map<String, String> resultMap, Integer pageNo, Integer pageSize);
	//根据用户ID查询角色（role），放入到Authorization里。
	Set<String> findRoleByUserId(Long userId);

	List<SysRole> findNowAllPermission();
	//初始化数据
	void initData();
}
