package com.ccbjb.service.user.impl;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.common.domain.SysUserRole;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.SysUserDao;
import com.ccbjb.dao.SysUserRoleDao;
import com.ccbjb.logic.user.UserManager;
import com.ccbjb.model.permission.SysRoleModel;
import com.ccbjb.service.user.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhulin on 2017/3/18.
 */
@Service
public class UserServiceImpl implements IUserService {
    /***
     * 用户手动操作Session
     * */
    //@Autowired
    //CustomSessionManager customSessionManager;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    SysUserRoleDao sysUserRoleDao;

    @Override
    public void deleteByPrimaryKey(Long id) {
        sysUserDao.deleteById(id);
    }

    @Transactional
    @Override
    public SysUser insert(SysUser entity) {

        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        entity.setSalt(salt);

        UserManager.md5Pswd(entity);
        Date date = new Date();
        entity.setCreateTime(date);
        entity.setLastLoginTime(date);
        //设置有效
        entity.setStatus(SysUser._1);
        sysUserDao.save(entity);
        return entity;
    }
    @Transactional
    @Override
    public SysUser insertSelective(SysUser entity) {
        sysUserDao.save(entity);
        return entity;
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return sysUserDao.findById(id);
    }
    @Transactional
    @Override
    public void updateByPrimaryKey(SysUser entity) {
        sysUserDao.update(entity);
    }
    @Transactional
    @Override
    public void updateByPrimaryKeySelective(SysUser entity) {
        sysUserDao.update(entity);
    }

    @Override
    public SysUser login(SysUser user) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("email", user.getEmail());
        user = UserManager.md5Pswd(user);
        map.put("pswd", user.getPswd());
        return sysUserDao.login(map);
    }

    @Override
    public SysUser findUserByEmail(String email) {
        return sysUserDao.findUserByEmail(email);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Result findByPage(Map<String, String> resultMap,
                             Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<SysUser> list = sysUserDao.findAllUsers(resultMap);
        PageInfo pageInfo = new PageInfo(list);

        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @Transactional
    @Override
    public Result deleteUserById(Long[] ids) {
        Result result = null;
        try {
            int count=0;

            for (Long id : ids) {
                this.deleteByPrimaryKey(id);
                count++;
            }
            result = ResultGenerator.genSuccessResult("成功删除"+ count +"个！");
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
            result = ResultGenerator.genFailResult();
        }
        return result;
    }

    @Transactional
    @Override
    public Result updateForbidUserById(Long id, Long status) {
        Result result = null;
        try {
            SysUser user = selectByPrimaryKey(id);
            user.setStatus(status);
            updateByPrimaryKeySelective(user);

            //如果当前用户在线，需要标记并且踢出  踢出功能暂未实现
            //customSessionManager.forbidUserById(id,status);

            result = ResultGenerator.genSuccessResult("操作成功");
        } catch (Exception e) {
            result = ResultGenerator.genFailResult();
            LoggerUtils.fmtError(getClass(), "禁止或者激活用户登录失败，id[%s],status[%s]", id,status);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Result findUserAndRole(Map<String, String> map, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<SysUser> list = sysUserDao.findUserAndRole(map);
        PageInfo pageInfo = new PageInfo(list);

        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @Override
    public List<SysRoleModel> selectRoleByUserId(Long id) {
        return sysUserDao.selectRoleByUserId(id);
    }

    @Transactional
    @Override
    public Result addRole2User(Long userId, Long[] ids) {
        Result result = null;
        int count = 0;
        try {
            //先删除原有的。
            sysUserRoleDao.deleteById(userId);
            //如果ids,role 的id 有值，那么就添加。没值象征着：把这个用户（userId）所有角色取消。
            if(ids.length>0){
                //添加新的。
                for (Long id : ids) {
                	SysUserRole entity = new SysUserRole(userId,id);
                    sysUserRoleDao.save(entity);
                    count ++;
                }
            }
            result = ResultGenerator.genSuccessResult("成功添加"+count+"个角色！");
        } catch (Exception e) {
            result = ResultGenerator.genFailResult();
        }
        //清空用户的权限，迫使再次获取权限的时候，得重新加载
        //TODO session未持久化 不能清空用户权限
        //TokenManager.clearUserAuthByUserId(userId);
        return result;
    }

    @Transactional
    @Override
    public Result deleteRoleByUserIds(Long[] userIds) {

        Map<String,Object> resultMap = new HashMap<String, Object>();
        Result result = null;
        try {
        	if(StringUtils.isNotBlank(userIds)){
        		StringBuilder sb = new StringBuilder();
        		for (Long id : userIds) {
        			sb.append(id);
        			sb.append(",");
        		}
        		String userIdsSbString = sb.toString();
        		resultMap.put("userIds", userIdsSbString.substring(0, userIdsSbString.length()-1));
        		sysUserRoleDao.deleteRoleByUserIds(resultMap);
        		result = ResultGenerator.genSuccessResult("操作成功");
        	}
        } catch (Exception e) {
            result = ResultGenerator.genFailResult();
        }
        return result;

    }


}
