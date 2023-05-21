package com.codegym.model;

import com.codegym.service.IModel;
import com.codegym.service.RentalItemService;
import com.codegym.utils.CurrencyUtils;
import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalOrder implements IModel<RentalOrder> {
    private long orderID;
    private long userID;
    private String userName;
    private String address;
    private String phone;
    private Date rentalDate;
    private Date returnDate;
    private EOrderStatus orderStatus;
    private double grandTotal;
    List<RentalItem> rentalItems;

    public List<RentalItem> getRentalItems() {
        return rentalItems;
    }

    public void setRentalItems(List<RentalItem> rentalItems) {
        this.rentalItems = rentalItems;
    }
    public RentalOrder() {
        rentalItems = new ArrayList<>();
    }
    public void addRentalItem(RentalItem rentalItem) {
        rentalItems.add(rentalItem);
    }

    public void updateOrder(RentalOrder rentalOrder) {
        this.setOrderStatus(rentalOrder.getOrderStatus());

    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public String toString() {
        return orderID +
                "," + userID +
                "," + userName+
                "," + address+
                "," + phone+
                "," + DateUtils.convertDateToString(rentalDate) +
                "," + DateUtils.convertDateToString(returnDate) +
                "," + orderStatus.getId() +
                "," + CurrencyUtils.convertPriceToString(grandTotal);
    }
    public String toData() {
        return String.format("║%15s║ %15s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %16s║",orderID,userID,userName,address,phone,DateUtils.convertDateToString(rentalDate),DateUtils.convertDateToString(returnDate),orderStatus,CurrencyUtils.convertPriceToString(grandTotal));
    }

    @Override
    public RentalOrder parseData(String line) {
        RentalOrder order = new RentalOrder();
        String[] strings = line.split(",");
        int orderID = Integer.parseInt(strings[0]);
        int userID = Integer.parseInt(strings[1]);
        String username = strings[2];
        String address = strings[3];
        String phone = strings[4];
        Date rentalDate = DateUtils.convertStringToDate(strings[5]);
        Date returnDate = DateUtils.convertStringToDate(strings[6]);
        int idOrderStatus = Integer.parseInt(strings[7]);
        double grandtotal = CurrencyUtils.parseDouble(strings[8]);
        order.setOrderID(orderID);
        order.setUserID(userID);
        order.setUserName(username);
        order.setAddress(address);
        order.setPhone(phone);
        order.setRentalDate(rentalDate);
        order.setReturnDate(returnDate);
        order.setGrandTotal(grandtotal);
        EOrderStatus orderStatus1 = EOrderStatus.findOrderStatusByID(idOrderStatus);
        order.setOrderStatus(orderStatus1);
        return order;
    }
}

