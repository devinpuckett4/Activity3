package com.gcu.topic2.model;

public class OrderModel {
    private Long id;
    private String orderNo;
    private String productName;
    private float price;
    private int quantity;

    public OrderModel(Long id, String orderNo, String productName, float price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public String getOrderNo() { return orderNo; }
    public String getProductName() { return productName; }
    public float getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setId(Long id) { this.id = id; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(float price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}