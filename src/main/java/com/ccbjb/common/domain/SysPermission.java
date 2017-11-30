package com.ccbjb.common.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 权限实体
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
public class SysPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	/** 操作的url */
	private String url;
	/** 操作的名称 */
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}