package com.ccbjb.service.permission.impl;

import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.domain.SysRolePermission;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.SysPermissionDao;
import com.ccbjb.dao.SysRolePermissionDao;
import com.ccbjb.dao.SysUserDao;
import com.ccbjb.dao.SysUserRoleDao;
import com.ccbjb.model.permission.SysPermissionModel;
import com.ccbjb.service.permission.IPermissionService;
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
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	SysPermissionDao permissionDao;
	@Autowired
	SysUserDao userDao;
	@Autowired
	SysRolePermissionDao rolePermissionDao;
	@Autowired
	SysUserRoleDao userRoleDao;

	@Transactional
	@Override
	public void deleteByPrimaryKey(Long id) {
		permissionDao.deleteById(id);
	}

	@Transactional
	@Override
	public SysPermission insert(SysPermission record) {
		permissionDao.save(record);
		return record;
	}

	@Transactional
	@Override
	public SysPermission insertSelective(SysPermission record) {
		//添加权限
		permissionDao.save(record);
		//每添加一个权限，都往【系统管理员 	SYS_ADMIN】里添加一次。保证系统管理员有最大的权限
		executePermission(new Long(1), new Long[]{record.getId()});
		return record;
	}

	@Override
	public SysPermission selectByPrimaryKey(Long id) {
		return permissionDao.findById(id);
	}

	@Transactional
	@Override
	public void updateByPrimaryKey(SysPermission record) {
		permissionDao.update(record);
	}

	@Transactional
	@Override
	public void updateByPrimaryKeySelective(SysPermission record) {
		permissionDao.update(record);
	}

	@Transactional
	@Override
	public Result deletePermissionById(Long[] ids) {
		Result result = null;
		try {
			int successCount=0,errorCount=0;
			String resultMsg ="删除%s条，失败%s条";
			
			for (Long id : ids) {
				
				List<SysRolePermission> rolePermissions= rolePermissionDao.findRolePermissionByPid(id);
				if(null != rolePermissions && rolePermissions.size() > 0){
					this.deleteByPrimaryKey(id);
					successCount++;
				}else{
					errorCount ++;
				}
			}
			//如果有成功的，也有失败的，提示清楚。
			if(errorCount > 0){
				resultMsg = String.format(resultMsg, successCount,errorCount);
			}else{
				resultMsg = "操作成功";
			}
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Result findPage(Map<String,String> map, Integer pageNo,
                           Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<SysPermission> list = permissionDao.findAllPermissions(map);
		PageInfo pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Override
	public List<SysPermissionModel> selectPermissionById(Long id) {
		return permissionDao.selectPermissionById(id);
	}

	@Transactional
	@Override
	public Result addPermission2Role(Long roleId, Long[] ids) {
		//先删除原有的。
		rolePermissionDao.deleteByRid(roleId);
		return executePermission(roleId, ids);
	}
	/**
	 * 处理权限 
	 * @param roleId
	 * @param ids
	 * @return
	 */
	@Transactional
	private Result executePermission(Long roleId, Long[] ids){
		Result result = null;
		int count = 0;
		try {
			//如果ids,permission 的id 有值，那么就添加。没值象征着：把这个角色（roleId）所有权限取消。
			if(ids.length>0){
				//添加新的。
				for (Long id : ids) {
					SysRolePermission entity = new SysRolePermission(roleId,id);
					rolePermissionDao.save(entity);
					count ++;
				}
			}
			result = ResultGenerator.genSuccessResult("操作清空"+count+"个权限！");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
		}
		//清空拥有角色Id为：roleId 的用户权限已加载数据，让权限数据重新加载
		//List<Long> userIds = userRoleMapper.findUserIdByRoleId(roleId);
		//TODO session未持久化 不能清空用户权限
		//TokenManager.clearUserAuthByUserId(userIds);
		return result;
		
	}

	@Transactional
	@Override
	public Result deleteByRids(Long[] roleIds) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		Result result = null;
		try {
			if(StringUtils.isNotBlank(roleIds)){
				StringBuilder sb = new StringBuilder();
				for (Long id : roleIds) {
					sb.append(id);
					sb.append(",");
				}
				String roleIdsSbString = sb.toString();
				resultMap.put("roleIds", roleIdsSbString.substring(0, roleIdsSbString.length()-1));
				
				rolePermissionDao.deleteByRids(resultMap);
				result = ResultGenerator.genSuccessResult("操作成功！");
			}
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

	@Override
	public Set<String> findPermissionByUserId(Long userId) {
		return permissionDao.findPermissionByUserId(userId);
	}

	
}
