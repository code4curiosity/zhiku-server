package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.SysRole;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SysRoleMapper extends TKMMapper<SysRole> {

    List<SysRole> findAllRoles(Map<String, String> map);

    List<SysRole> findRoleAndPermission();

    Set<String> findRoleByUserId(Long id);

    List<SysRole> findNowAllPermission(Map<String, Object> map);

    void initData();
}