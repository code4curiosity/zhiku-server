package com.ccbjb.dao;


import com.ccbjb.common.domain.SysRole;
import com.ccbjb.common.mybatis.BaseDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface SysRoleDao extends BaseDao<SysRole> {

    List<SysRole> findAllRoles(Map<String, String> map);

    List<SysRole> findRoleAndPermission();

    Set<String> findRoleByUserId(Long id);

    List<SysRole> findNowAllPermission(Map<String, Object> map);

    void initData();

}
