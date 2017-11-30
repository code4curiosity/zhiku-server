package com.ccbjb.model.points;

import com.ccbjb.common.domain.TCuts;
import com.ccbjb.common.domain.TPoints;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class TPointsModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long parentId;
    private String title;
    private String detail;
    private Integer type;

    private Integer pOrder;

    private List<TPoints> parents = new ArrayList<TPoints>();

    private List<TPointsModel> items = new ArrayList<TPointsModel>();

    private List<TCuts> cuts = new ArrayList<TCuts>();

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

    public List<TPointsModel> getItems() {
        return items;
    }
    public void setItems(List<TPointsModel> items) {
        this.items = items;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public List<TPoints> getParents() {
        return parents;
    }
    public void setParents(List<TPoints> parents) {
        this.parents = parents;
    }

    public Integer getpOrder() {
        return pOrder;
    }

    public void setpOrder(Integer pOrder) {
        this.pOrder = pOrder;
    }


    public List<TCuts> getCuts() {
        return cuts;
    }

    public void setCuts(List<TCuts> cuts) {
        this.cuts = cuts;
    }
}
