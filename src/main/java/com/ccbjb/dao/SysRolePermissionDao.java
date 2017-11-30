package com.ccbjb.dao;

import com.ccbjb.common.domain.SysRolePermission;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface SysRolePermissionDao extends BaseDao<SysRolePermission> {


    List<SysRolePermission> findRolePermissionByPid(Long id);

    List<SysRolePermission> findRolePermissionByRid(Long id);

    List<SysRolePermission> find(SysRolePermission entity);

    int deleteByPid(Long id);
    int deleteByRid(Long id);
    int deleteByEntity(SysRolePermission entity);

    int deleteByRids(Map<String, Object> resultMap);
}
