package com.codegym.service;

import com.codegym.model.RentalOrder;
import com.codegym.utils.FileUtils;

import java.util.List;

public class RentalOrderService implements IRentalOrderService{
    public final String filePath = "F:\\BaoThi\\CaseStudy_Module2\\src\\main\\java\\com\\codegym\\data\\rentalorder.csv";
    @Override
    public List<RentalOrder> getAllOrders() {
        return FileUtils.readData(filePath, RentalOrder.class);
    }

    @Override
    public void add(RentalOrder order) {
        List<RentalOrder> rentalOrders = getAllOrders();
        rentalOrders.add(order);
        FileUtils.writeDataToFile(filePath, rentalOrders);
    }

    @Override
    public RentalOrder findById(long orderId) {
        List<RentalOrder> rentalOrders = getAllOrders();
        for (RentalOrder rentalOrder : rentalOrders) {
            if (rentalOrder.getOrderID() == orderId)
                return  rentalOrder;
        }
        return null;
    }

    @Override
    public void update(RentalOrder newOrder) {

        }


}
