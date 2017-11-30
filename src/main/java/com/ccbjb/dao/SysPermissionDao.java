package com.ccbjb.dao;

import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mybatis.BaseDao;
import com.ccbjb.model.permission.SysPermissionModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface SysPermissionDao extends BaseDao<SysPermission> {

    List<SysPermission> findAllPermissions(Map<String, String> map);
    List<SysPermissionModel> selectPermissionById(Long id);
    //根据用户ID获取权限的Set集合
    Set<String> findPermissionByUserId(Long id);
}
