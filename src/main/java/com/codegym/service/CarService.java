package com.codegym.service;

import com.codegym.model.Car;
import com.codegym.utils.FileUtils;

import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    public static Scanner scanner = new Scanner(System.in);
    public FileUtils fileUtils;
    private final String filePath = "F:\\BaoThi\\CaseStudy_Module2\\src\\main\\java\\com\\codegym\\data\\car.csv";
    @Override
    public List<Car> getAllCars() {
        return FileUtils.readData(filePath,Car.class);
    }

    @Override
    public void addCar(Car car) {
        List<Car> cars = getAllCars();
        cars.add(car);
        FileUtils.writeDataToFile(filePath,cars);
    }

    @Override
    public void updateCar(Car car, long id) {

    }

    @Override
    public void removeCarById(long id, List<Car> cars) {

    }

}
