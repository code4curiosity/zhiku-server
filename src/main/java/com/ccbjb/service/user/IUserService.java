package com.ccbjb.service.user;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.model.permission.SysRoleModel;

import java.util.List;
import java.util.Map;

/**
 * Created by zhulin on 2017/3/18.
 */
public interface IUserService {
    void deleteByPrimaryKey(Long id);

    SysUser insert(SysUser record);

    SysUser insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    void updateByPrimaryKeySelective(SysUser record);

    void updateByPrimaryKey(SysUser record);

    SysUser login(SysUser record);

    SysUser findUserByEmail(String email);

    Result findByPage(Map<String, String> resultMap, Integer pageNo,
                      Integer pageSize);

    Result deleteUserById(Long[] ids);

    Result updateForbidUserById(Long id, Long status);

    Result findUserAndRole(Map<String, String> map, Integer pageNo, Integer pageSize);

    List<SysRoleModel> selectRoleByUserId(Long id);

    Result addRole2User(Long userId, Long[] ids);

    Result deleteRoleByUserIds(Long[] userIds);
}
