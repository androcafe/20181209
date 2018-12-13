package com.example.windows.fooddeliveryapp.model;

public class AdminTakeOrder {
    int id;
    String date;
    String name;
    String address;
    String total;

    public AdminTakeOrder(int id, String date, String name, String address, String total) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.address = address;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
