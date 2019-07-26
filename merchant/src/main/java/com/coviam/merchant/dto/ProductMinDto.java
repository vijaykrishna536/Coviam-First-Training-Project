package com.coviam.merchant.dto;

import java.io.Serializable;

public class ProductMinDto implements Serializable {

    private String id;
    private String pId;
    private String name;
    private String picUrl;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}