package com.example.windows.fooddeliveryapp.model;

public class ViewCart {
    String item_type;
    String item_name;
    String qty;
    String price;

    public ViewCart(String item_type, String item_name, String qty, String price) {
        this.item_type = item_type;
        this.item_name = item_name;
        this.qty = qty;
        this.price = price;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
