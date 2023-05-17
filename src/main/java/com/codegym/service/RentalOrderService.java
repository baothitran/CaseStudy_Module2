package com.codegym.service;

import com.codegym.model.Car;
import com.codegym.model.RentalOrder;
import com.codegym.utils.FileUtils;

import java.util.ArrayList;
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
    public List<RentalOrder> findOrderByStatus(List<RentalOrder> rentalOrderList, int idStatus) {
        List<RentalOrder> rentalOrders = new ArrayList<>();
        for (RentalOrder rentalOrder : rentalOrderList) {
            if (rentalOrder.getOrderStatus().getId() == idStatus) {
                rentalOrders.add(rentalOrder);
            }
        }
        return rentalOrders;
    }

    @Override
        public boolean existById(long id) {
            return findById(id) != null;
        }

    @Override
    public void updateOrder(RentalOrder rentalOrder, long id) {
        List<RentalOrder> rentalOrders = getAllOrders();
        for(RentalOrder rentalOrder1 : rentalOrders) {
            if (rentalOrder1.getOrderID() == id) {
                rentalOrder1.updateOrder(rentalOrder);
                FileUtils.writeDataToFile(filePath, rentalOrders);
                break;
            }
        }
    }


}
