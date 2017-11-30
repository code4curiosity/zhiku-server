package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.SysUserRole;
import com.ccbjb.common.mapper.SysUserRoleMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.SysUserRoleDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class SysUserRoleDaoImpl extends AbstractDao<SysUserRole> implements SysUserRoleDao {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int deleteByUserId(Long id) {
        return sysUserRoleMapper.deleteByUserId(id);
    }

    @Override
    public int deleteRoleByUserIds(Map<String, Object> resultMap) {
        return sysUserRoleMapper.deleteRoleByUserIds(resultMap);
    }

    @Override
    public List<Long> findUserIdByRoleId(Long id) {
        return sysUserRoleMapper.findUserIdByRoleId(id);
    }
}
