package com.coviam.merchant.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

//@Document(collection = Merchant.COLLECTION_NAME)
public class Inventory implements Serializable {

    public static final String COLLECTION_NAME = "inventory";

    @Id
    private String id;

    // https://docs.spring.io/spring-data/mongodb/docs/1.3.3.RELEASE/reference/html/mapping-chapter.html
    private String merchantId;
    private String productId;

    private Double price;
    private Integer stock;
    private Integer sold;
    private String productName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
