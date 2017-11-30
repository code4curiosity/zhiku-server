package com.ccbjb.common.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 权限角色
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
public class SysRole implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    /**角色名称*/
    private String name;
    /**角色类型*/
    private String type;
    //***做 role --> permission 一对多处理
    @Transient
    private List<SysPermission> permissions = new LinkedList<SysPermission>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public void setType(String type) {
        this.type = type;
    }
}