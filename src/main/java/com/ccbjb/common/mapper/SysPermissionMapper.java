package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mybatis.TKMMapper;
import com.ccbjb.model.permission.SysPermissionModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SysPermissionMapper extends TKMMapper<SysPermission> {
    List<SysPermission> findAllPermissions(Map<String, String> map);
    List<SysPermissionModel> selectPermissionById(Long id);
    //根据用户ID获取权限的Set集合
    Set<String> findPermissionByUserId(Long id);
}