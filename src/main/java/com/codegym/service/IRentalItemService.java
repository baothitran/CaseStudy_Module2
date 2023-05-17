package com.codegym.service;

import com.codegym.model.RentalItem;

import java.util.List;

public interface IRentalItemService {
    List<RentalItem> getAllRentalItems();
    List<RentalItem> findByRentalOrderId(long orderId);
    void addRentalItem (List<RentalItem> rentalItems);

}
