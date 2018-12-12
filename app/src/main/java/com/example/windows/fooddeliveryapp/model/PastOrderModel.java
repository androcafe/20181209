package com.example.windows.fooddeliveryapp.model;

public class PastOrderModel {

    String order_name;
    String order_at;
    String order_total;
    String order_status;

    public PastOrderModel(String order_name, String order_at, String order_total, String order_status) {
        this.order_name = order_name;
        this.order_at = order_at;
        this.order_total = order_total;
        this.order_status = order_status;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_at() {
        return order_at;
    }

    public void setOrder_at(String order_at) {
        this.order_at = order_at;
    }

    public String getOrder_total() {
        return order_total;
    }

    public void setOrder_total(String order_total) {
        this.order_total = order_total;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
