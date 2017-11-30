package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.SysRolePermission;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;
import java.util.Map;

public interface SysRolePermissionMapper extends TKMMapper<SysRolePermission> {
    List<SysRolePermission> findRolePermissionByPid(Long id);

    List<SysRolePermission> findRolePermissionByRid(Long id);

    List<SysRolePermission> find(SysRolePermission entity);

    int deleteByPid(Long id);
    int deleteByRid(Long id);
    int deleteByEntity(SysRolePermission entity);

    int deleteByRids(Map<String, Object> resultMap);
}