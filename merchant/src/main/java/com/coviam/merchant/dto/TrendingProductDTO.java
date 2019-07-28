package com.coviam.merchant.dto;

import java.io.Serializable;

public class TrendingProductDTO implements Serializable, Comparable<TrendingProductDTO> {
    private String name;
    private String productId;
    private String picUrl;
    private String categoryName;
    private Integer stock;
    private Integer sold;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    @Override
    public int compareTo(TrendingProductDTO other) {
        return Integer.compare(this.getSold(), other.getSold());
    }
}
