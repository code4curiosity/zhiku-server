package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.SysRole;
import com.ccbjb.common.mapper.SysRoleMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.SysRoleDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class SysRoleDaoImpl extends AbstractDao<SysRole> implements SysRoleDao {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Cacheable("findAllRoles")
    @Override
    public List<SysRole> findAllRoles(Map<String, String> map) {
        return sysRoleMapper.findAllRoles(map);
    }

    @Override
    public List<SysRole> findRoleAndPermission() {
        return sysRoleMapper.findRoleAndPermission();
    }

    @Override
    public Set<String> findRoleByUserId(Long id) {
        return sysRoleMapper.findRoleByUserId(id);
    }

    @Override
    public List<SysRole> findNowAllPermission(Map<String, Object> map) {
        return sysRoleMapper.findNowAllPermission(map);
    }

    @Override
    public void initData() {
        sysRoleMapper.initData();
    }
}
