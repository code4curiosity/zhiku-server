package com.ccbjb.common.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccbjb.common.utils.StringUtils;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTips implements Serializable{

    private static final long serialVersionUID = 7985255432421244582L;
    @Id
    private Long id;
    private Long parentId;
    private int tipsNo;
    private String tipsTitle;
    private String funcTitle;
    private String funcDesc;
    @Transient
    private List<TTipsFunc> tipsFuncList = new ArrayList<>();
    private String tipsCode;
    private String tipsExplain;
    private String explainTable;
    private String imgBefore;
    private String imgAfter;
    private String noticeTitle;
    private String noticeContent;
    private String noticeCode;
    private String imgBeforeDesc;
    private String imgAfterDesc;
    private Date createTime;
    private Date updateTime;
    @Transient
    private JSONArray explainTableObj;
    @Transient
    private String tipsCodeObj;
    @Transient
    private String noticeCodeObj;

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

    public int getTipsNo() {
        return tipsNo;
    }

    public void setTipsNo(int tipsNo) {
        this.tipsNo = tipsNo;
    }

    public String getTipsTitle() {
        return tipsTitle;
    }

    public void setTipsTitle(String tipsTitle) {
        this.tipsTitle = tipsTitle;
    }

    public String getFuncTitle() {
        return funcTitle;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    public List<TTipsFunc> getTipsFuncList() {
        return tipsFuncList;
    }

    public void setTipsFuncList(List<TTipsFunc> tipsFuncList) {
        this.tipsFuncList = tipsFuncList;
    }

    public String getTipsCode() {
        return tipsCode;
    }

    public void setTipsCode(String tipsCode) {
        this.tipsCode = tipsCode;
    }

    public String getTipsExplain() {
        return tipsExplain;
    }

    public void setTipsExplain(String tipsExplain) {
        this.tipsExplain = tipsExplain;
    }

    public String getExplainTable() {
        return explainTable;
    }

    public void setExplainTable(String explainTable) {
        this.explainTable = explainTable;
    }

    public String getImgBefore() {
        return imgBefore;
    }

    public void setImgBefore(String imgBefore) {
        this.imgBefore = imgBefore;
    }

    public String getImgAfter() {
        return imgAfter;
    }

    public void setImgAfter(String imgAfter) {
        this.imgAfter = imgAfter;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    public String getImgBeforeDesc() {
        return imgBeforeDesc;
    }

    public void setImgBeforeDesc(String imgBeforeDesc) {
        this.imgBeforeDesc = imgBeforeDesc;
    }

    public String getImgAfterDesc() {
        return imgAfterDesc;
    }

    public void setImgAfterDesc(String imgAfterDesc) {
        this.imgAfterDesc = imgAfterDesc;
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

    public JSONArray getExplainTableObj() {
        return explainTableObj;
    }

    public void setExplainTableObj(String explainTable) {
        try {
            this.explainTableObj = JSON.parseArray(explainTable);
        }catch (Exception e) {
            List<String> temp = new ArrayList<>();
            temp.add(explainTable);
            this.explainTableObj = JSON.parseArray(temp.toString());;
        }
    }

    public String getTipsCodeObj() {
        return tipsCodeObj;
    }

    public void setTipsCodeObj(String tipsCode) {
        if(StringUtils.isNotBlank(tipsCode)) {
            this.tipsCodeObj = tipsCode.replaceAll("@","&#10;");
        }
    }


    public String getNoticeCodeObj() {
        return noticeCodeObj;
    }

    public void setNoticeCodeObj(String noticeCode) {
        if(StringUtils.isNotBlank(noticeCode)) {
            this.noticeCodeObj = noticeCode.replaceAll("@","&#10;");
        }
    }
}
