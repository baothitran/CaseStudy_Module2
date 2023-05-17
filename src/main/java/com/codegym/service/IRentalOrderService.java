package com.codegym.service;

import com.codegym.model.Car;
import com.codegym.model.RentalOrder;

import java.util.List;

public interface IRentalOrderService {
    List<RentalOrder> getAllOrders();
    void add(RentalOrder order);
    RentalOrder findById(long orderId);
    List<RentalOrder> findOrderByStatus(List<RentalOrder> rentalOrderList, int idStatus);
    boolean existById(long id);
    void updateOrder(RentalOrder rentalOrder, long id);
}
