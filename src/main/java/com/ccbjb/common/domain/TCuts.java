package com.ccbjb.common.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class TCuts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String cutUrl;
    private Long pointId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCutUrl() {
        return cutUrl;
    }

    public void setCutUrl(String cutUrl) {
        this.cutUrl = cutUrl;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }


}
