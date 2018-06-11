package com.ccbjb.common.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TZhikuInfo implements Serializable{

    private static final long serialVersionUID = 7985255432421244582L;
    @Id
    private Long id;
    private Long parentId;
    private Long categoryId;
    private String infoTitle;
    private String infoOrder;
    private String infoContent;
    private Date createTime;
    private Date updateTime;
    @Transient
    private List<TZhikuInfo> infoParents = new ArrayList<>();
    @Transient
    private List<TZhikuInfo> infoItems = new ArrayList<>();
    @Transient
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoOrder() {
        return infoOrder;
    }

    public void setInfoOrder(String infoOrder) {
        this.infoOrder = infoOrder;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<TZhikuInfo> getInfoParents() {
        return infoParents;
    }

    public void setInfoParents(List<TZhikuInfo> infoParents) {
        this.infoParents = infoParents;
    }

    public List<TZhikuInfo> getInfoItems() {
        return infoItems;
    }

    public void setInfoItems(List<TZhikuInfo> infoItems) {
        this.infoItems = infoItems;
    }
}
