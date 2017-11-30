package com.ccbjb.service.permission.impl;

import com.ccbjb.common.domain.SysRole;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.shiro.TokenManager;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.dao.SysRoleDao;
import com.ccbjb.dao.SysRolePermissionDao;
import com.ccbjb.dao.SysUserDao;
import com.ccbjb.service.permission.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@SuppressWarnings("unchecked")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private SysRoleDao roleDao;
	@Autowired
	private SysUserDao userDao;
	@Autowired
	private SysRolePermissionDao rolePermissionDao;

	@Transactional
	@Override
	public void deleteByPrimaryKey(Long id) {
		roleDao.deleteById(id);
	}

	@Transactional
	@Override
	public void insert(SysRole record) {
		roleDao.save(record);
	}

	@Transactional
	@Override
	public void insertSelective(SysRole record) {
		roleDao.save(record);
	}

	@Override
	public SysRole selectByPrimaryKey(Long id) {
		return roleDao.findById(id);
	}

	@Transactional
	@Override
	public void updateByPrimaryKey(SysRole record) {
		roleDao.update(record);
	}

	@Transactional
	@Override
	public void updateByPrimaryKeySelective(SysRole record) {
		roleDao.update(record);
	}

	@Transactional
	@Override
	public Result findPage(Map<String, String> resultMap,
                           Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<SysRole> list = roleDao.findAllRoles(resultMap);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Transactional
	@Override
	public Result findRoleAndPermissionPage(
			Map<String, String> resultMap, Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<SysRole> list = roleDao.findRoleAndPermission();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Transactional
	@Override
	public Result deleteRoleById(Long[] ids) {
		Result result = null;
		try {
			int count=0;
			String resultMsg = "";
			
			c:for (Long id : ids) {
				if(new Long(1).equals(id)){
					resultMsg = "操作成功，But'系统管理员不能删除。";
					continue c;
				}else{
					this.deleteByPrimaryKey(id);
					count++;
				}
			}
			resultMsg = "成功删除"+count+"个角色！";
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

	@Override
	public Set<String> findRoleByUserId(Long userId) {
		return roleDao.findRoleByUserId(userId);
	}

	@Override
	public List<SysRole> findNowAllPermission() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", TokenManager.getUserId());
//		map.put("userId", 11);
		return roleDao.findNowAllPermission(map);
	}
	/**
	 * 每20分钟执行一次
	 */
	@Override
	public void initData() {
		roleDao.initData();
	}
	
}
