package com.ccbjb.common.shiro;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.service.permission.IPermissionService;
import com.ccbjb.service.permission.IRoleService;
import com.ccbjb.service.user.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/16.
 */
public class TKMShiroRealm extends AuthorizingRealm {

	@Autowired
    IUserService userService;
	@Autowired
    IPermissionService permissionService;
	@Autowired
    IRoleService roleService;

	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("tKMShiroRealm");
	}

    // 用于认证
    //没有连接数据库的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		// token是用户输入的用户名和密码
		// 第一步从token中取出用户名
		String userCode = (String) token.getPrincipal();
		// 第二步：根据用户输入的userCode从数据库查询
		SysUser user = userService.findUserByEmail(userCode);
		if(null == user){
			throw new AccountException("帐号不存在！");
			/**
			 * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
			 */
		}else if(SysUser._0.equals(user.getStatus())){
			throw new DisabledAccountException("帐号已经禁止登录！");
		}else{
			//更新登录时间 last login time
			user.setLastLoginTime(new Date());
			userService.updateByPrimaryKeySelective(user);
		}
		return new SimpleAuthenticationInfo(user,user.getPswd(), ByteSource.Util.bytes(user.getEmail()+user.getSalt()), this.getName());
	}


    /**
     * 用于授权
     * @param principals
     * @return
     */
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		SysUser sysUser =  (SysUser) principals.getPrimaryPrincipal();

		Long userId = sysUser.getId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		//根据用户ID查询角色（role），放入到Authorization里。
		Set<String> roles = roleService.findRoleByUserId(userId);
		info.setRoles(roles);
		//根据用户ID查询权限（permission），放入到Authorization里。
		Set<String> permissions = permissionService.findPermissionByUserId(userId);
		info.setStringPermissions(permissions);

        return info;
    }

	/**
	 * 清空当前用户权限信息
	 */
	public  void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 指定principalCollection 清除
	 */
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}
