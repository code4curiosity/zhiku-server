package com.ccbjb.common.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TZhikuCategory implements Serializable{
    @Id
    private Long id;
    private Long parentId;
    private String categoryValue;
    private String categoryLabel;
    private String description;
    private Date createTime;
    private Date updateTime;
    private String imgPath;
    private String sourceType;
    @Transient
    private List<TZhikuCategory> categoryParents = new ArrayList<>();
    @Transient
    private List<TZhikuCategory> categoryItems = new ArrayList<>();

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

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public List<TZhikuCategory> getCategoryParents() {
        return categoryParents;
    }

    public void setCategoryParents(List<TZhikuCategory> categoryParents) {
        this.categoryParents = categoryParents;
    }

    public List<TZhikuCategory> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<TZhikuCategory> categoryItems) {
        this.categoryItems = categoryItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
}
