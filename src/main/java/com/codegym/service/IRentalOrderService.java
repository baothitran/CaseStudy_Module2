package com.codegym.service;

import com.codegym.model.RentalOrder;

import java.util.List;

public interface IRentalOrderService {
    List<RentalOrder> getAllOrders();
    void add(RentalOrder order);
    RentalOrder findById(long orderId);
    void update(RentalOrder newOrder);
}
