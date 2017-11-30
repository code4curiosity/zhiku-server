package com.ccbjb.dao;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.common.mybatis.BaseDao;
import com.ccbjb.model.permission.SysRoleModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public interface SysUserDao extends BaseDao<SysUser> {

    List<SysUser> findAllUsers(Map<String, String> map);

    List<SysUser> findUserAndRole(Map<String, String> map);

    SysUser login(Map<String, Object> map);

    SysUser findUserByEmail(String email);

    List<SysRoleModel> selectRoleByUserId(Long id);
}
