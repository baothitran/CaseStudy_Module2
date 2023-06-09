package com.codegym.model;

import com.codegym.service.IModel;
import com.codegym.utils.CurrencyUtils;

public class Car implements IModel<Car> {
    private long id;
    private String name;
    private String brand;
    private int quantity;
    private EType type;
    private double rentalPrice;
    private ECarStatus status;


    public Car() {
    }

    public Car(long id, String name, String brand, EType type, double rentalPrice, ECarStatus status) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.rentalPrice = rentalPrice;
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public ECarStatus getStatus() {
        return status;
    }

    public void setStatus(ECarStatus status) {
        this.status = status;
    }

    public void updateCar (Car car) {
        this.setId(car.getId());
        this.setName(car.getName());
        this.setBrand(car.getBrand());
        this.setType(car.getType());
        this.setRentalPrice(car.getRentalPrice());
        this.setStatus(car.getStatus());
    }
    @Override
    public Car parseData(String line) {
        Car car = new Car();
        String[] strings = line.split(",");
        long id = Long.parseLong(strings[0]);
        String name = strings[1];
        String brand = strings[2];
        int idType = Integer.parseInt(strings[3]);
        double rentalPrice = CurrencyUtils.parseDouble(strings[4]);
        int idCarStatus = Integer.parseInt(strings[5]);
        EType type = EType.findTypeByID(idType);
        ECarStatus carStatus = ECarStatus.findCarStatusByID(idCarStatus);
        car.setRentalPrice(rentalPrice);
        car.setId(id);
        car.setBrand(brand);
        car.setName(name);
        car.setType(type);
        car.setStatus(carStatus);
        return car;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",id,name,brand,type.getIdType(),CurrencyUtils.convertPriceToString(rentalPrice),status.getId());
    }
    public String toData() {
        return String.format("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", id, name, brand,type,CurrencyUtils.convertPriceToString(rentalPrice),status);
    }
}
