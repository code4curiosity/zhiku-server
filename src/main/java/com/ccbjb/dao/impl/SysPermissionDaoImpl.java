package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mapper.SysPermissionMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.SysPermissionDao;
import com.ccbjb.model.permission.SysPermissionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class SysPermissionDaoImpl extends AbstractDao<SysPermission> implements SysPermissionDao {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> findAllPermissions(Map<String, String> map) {
        return sysPermissionMapper.findAllPermissions(map);
    }

    @Override
    public List<SysPermissionModel> selectPermissionById(Long id) {
        return sysPermissionMapper.selectPermissionById(id);
    }

    @Override
    public Set<String> findPermissionByUserId(Long id) {
        return sysPermissionMapper.findPermissionByUserId(id);
    }
}
