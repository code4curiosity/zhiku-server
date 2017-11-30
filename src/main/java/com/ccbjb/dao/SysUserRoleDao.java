package com.ccbjb.dao;


import com.ccbjb.common.domain.SysUserRole;
import com.ccbjb.common.mybatis.BaseDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface SysUserRoleDao extends BaseDao<SysUserRole> {

    int deleteByUserId(Long id);

    int deleteRoleByUserIds(Map<String, Object> resultMap);

    List<Long> findUserIdByRoleId(Long id);
}
