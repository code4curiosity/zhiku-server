package com.ccbjb.common.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 角色{@link SysRole}和 权限{@link SysPermission}中间表
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
public class SysRolePermission implements Serializable{
	private static final long serialVersionUID = 1L;
	/**{@link SysRole.id}*/
    @Id
    private Long rid;
    /**{@link SysPermission.id}*/
    private Long pid;

    public SysRolePermission() {
	}
    public SysRolePermission(Long rid, Long pid) {
    	this.rid = rid;
    	this.pid = pid;
    }
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}