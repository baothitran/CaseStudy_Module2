package com.codegym.service;

import com.codegym.model.Car;

import java.util.List;

public interface ICarService {
    List<Car> getAllCars();

    void addCar(Car car);
    void updateCar(Car car, long id);
    void removeCarById(long id);
    Car findCarById(long id);
    List<Car> findCarByName(String productName);
    boolean existsByName(String productName);
    boolean existById(long id);
    List<Car> findCarByStatus (List<Car> carList, int idCarStatus);
    List<Car> findCarByType(List<Car> carList, int idType);



}
