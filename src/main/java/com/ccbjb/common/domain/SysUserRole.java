package com.ccbjb.common.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户{@link SysUser} 和角色 {@link SysRole} 中间表
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
public class SysUserRole implements Serializable{
	private static final long serialVersionUID = 1L;
	 /**{@link SysUser.id}*/
     @Id
    private Long uid;
    /**{@link SysRole.id}*/
    private Long rid;

    public SysUserRole(Long uid, Long rid) {
    	this.uid = uid;
    	this.rid = rid;
	}
    public SysUserRole() {
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}