package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.common.mapper.SysUserMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.SysUserDao;
import com.ccbjb.model.permission.SysRoleModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class SysUserDaoImpl extends AbstractDao<SysUser> implements SysUserDao {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findUserAndRole(Map<String, String> map) {
        return sysUserMapper.findUserAndRole(map);
    }

    @Override
    public List<SysUser> findAllUsers(Map<String, String> map) {
        return sysUserMapper.findAllUsers(map);
    }

    @Override
    public SysUser login(Map<String, Object> map) {
        return sysUserMapper.login(map);
    }

    @Override
    public SysUser findUserByEmail(String email) {
        return sysUserMapper.findUserByEmail(email);
    }

    @Override
    public List<SysRoleModel> selectRoleByUserId(Long id) {
        return sysUserMapper.selectRoleByUserId(id);
    }
}
