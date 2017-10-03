package com.upic.po;

import com.upic.common.entity.BaseEntity;

public class OrderFarmDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String shopName; // 商品名

    private double price; // 原价

    private double cost; // 现价

    private int limit; // 限购

    private String brief; // 简介

    private String orderNumber; // 订单编号

    private int count; // 数量

    private double finalCost; // 单笔消费

    private String field1; // 添加字段1

    private String field2; // 添加字段2

    private String field3; // 添加字段3

    private String field4; // 添加字段4

    private String field5; // 添加字段5

    public OrderFarmDetails() {
        super();
    }

    public OrderFarmDetails(String shopName, double price, double cost, int limit, String brief, String orderNumber,
                            int count, double finalCost, String field1, String field2, String field3, String field4, String field5) {
        super();
        this.shopName = shopName;
        this.price = price;
        this.cost = cost;
        this.limit = limit;
        this.brief = brief;
        this.orderNumber = orderNumber;
        this.count = count;
        this.finalCost = finalCost;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }
}
