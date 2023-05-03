package com.codegym.service;

import com.codegym.model.Car;

import java.util.List;

public interface ICarService {
    List<Car> getAllCars();
    void addCar(Car car);
    void updateCar(Car car, long id);
    void removeCarById(long id, List<Car> cars);

}
