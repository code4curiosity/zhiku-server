package com.ccbjb.common.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class TPoints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private Long parentId;
    private String title;
    private Object detail;
    private Integer pOrder;
    private Integer type;

    @Transient
    private List<TPoints> items = new ArrayList<TPoints>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TPoints> getItems() {
        return items;
    }
    public void setItems(List<TPoints> items) {
        this.items = items;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }


    public Integer getpOrder() {
        return pOrder;
    }

    public void setpOrder(Integer pOrder) {
        this.pOrder = pOrder;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
