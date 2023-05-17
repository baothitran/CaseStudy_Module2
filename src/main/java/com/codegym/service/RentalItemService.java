package com.codegym.service;

import com.codegym.model.RentalItem;
import com.codegym.utils.FileUtils;
import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.ArrayList;
import java.util.List;

public class RentalItemService implements IRentalItemService{
    public final String filePath = "F:\\BaoThi\\CaseStudy_Module2\\src\\main\\java\\com\\codegym\\data\\rentalitem.csv";
    private static RentalItemService instance;
    FileUtils fileUtils;
    public RentalItemService() {
        fileUtils = new FileUtils();
    }
    public static RentalItemService getInstance() {
        if (instance == null) {
            instance = new RentalItemService();
        }
        return instance;
    }
    @Override
    public List<RentalItem> getAllRentalItems() {
        return FileUtils.readData(filePath, RentalItem.class);
    }

    @Override
    public List<RentalItem> findByRentalOrderId(long orderId) {
        List<RentalItem> rentalItems = getAllRentalItems();
        List<RentalItem> rentalItemList = new ArrayList<>();
        for(RentalItem rentalItem : rentalItems) {
            if (rentalItem.getOrderID() == orderId) {
                rentalItemList.add(rentalItem);
            }
        }
        if (rentalItemList.isEmpty()) {
            return null;
        }
        return rentalItemList;
    }

    @Override
    public void addRentalItem(List<RentalItem> rentalItems) {
        List<RentalItem> rentalItemList = getAllRentalItems();
        rentalItemList.addAll(rentalItems);
        FileUtils.writeDataToFile(filePath,rentalItemList);
    }
}
