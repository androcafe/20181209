package com.example.windows.fooddeliveryapp.model;

public class MenuModel {

    String menu_name;
    int menu_price;
    int qty;

    public MenuModel(String menu_name, int menu_price, int qty) {
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.qty = qty;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(int menu_price) {
        this.menu_price = menu_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
