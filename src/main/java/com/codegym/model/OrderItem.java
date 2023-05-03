package com.codegym.model;

import com.codegym.service.IModel;
import com.codegym.utils.CurrencyUtils;

public class OrderItem implements IModel<OrderItem> {
    private long id;
    private long carID;
    private long orderID;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(long id, long carID, long orderID, int quantity, double price) {
        this.id = id;
        this.carID = carID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", carID=" + carID +
                ", orderID=" + orderID +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public OrderItem parseData(String line) {
        OrderItem orderItem = new OrderItem();
        String[] strings = line.split(",");
        long id = Long.parseLong(strings[0]);
        long carID = Long.parseLong(strings[1]);
        long orderID = Long.parseLong(strings[2]);
        int quantity = Integer.parseInt(strings[3]);
        double price = CurrencyUtils.parseDouble(strings[4]);
        orderItem.setId(id);
        orderItem.setCarID(carID);
        orderItem.setOrderID(orderID);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(price);
        return orderItem;
    }
}
