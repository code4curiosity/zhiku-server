package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.common.mybatis.TKMMapper;
import com.ccbjb.model.permission.SysRoleModel;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends TKMMapper<SysUser> {

    List<SysUser> findAllUsers(Map<String, String> map);

    List<SysUser> findUserAndRole(Map<String, String> map);

    SysUser login(Map<String, Object> map);

    SysUser findUserByEmail(String email);

    List<SysRoleModel> selectRoleByUserId(Long id);
}