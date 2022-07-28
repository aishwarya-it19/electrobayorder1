package com.example.electrobayorder1.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {

    private String id;
    protected int userId;
    private int productId;
    private int quantity;
    private int merchantId;
    private int cartId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }



}
