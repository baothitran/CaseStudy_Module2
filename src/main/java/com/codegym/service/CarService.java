package com.codegym.service;

import com.codegym.model.Car;
import com.codegym.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
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
        List<Car> cars = getAllCars();
        for(Car car1 : cars) {
            if (car1.getId() == id) {
                car1.updateCar(car);
                FileUtils.writeDataToFile(filePath, cars);
                break;
            }
        }
    }

    @Override
    public void removeCarById(long id) {
        List<Car> cars = getAllCars();
        for (int i=0; i< cars.size(); i++) {
            if ((cars.get(i)).getId() == id) {
             cars.remove(cars.get(i));
            }
        }
        FileUtils.writeDataToFile(filePath, cars);
    }

    @Override
    public Car findCarById(long id) {
        List<Car> cars = getAllCars();
        for(Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public List<Car> findCarByName(String name) {
        List<Car> cars = getAllCars();
        List<Car> carList = new ArrayList<>();
        for (Car car1 : cars) {
            if ((car1.getName().toLowerCase()).contains(name.toLowerCase())) {
                carList.add(car1);
            }
        }
        if(carList.isEmpty()) {
            return null;
        }
        return carList;
    }

    @Override
    public boolean existsByName(String name) {
        List<Car> cars = getAllCars();
        for (Car car1 : cars) {
            if (car1.getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public boolean existById(long id) {
        return findCarById(id) != null;
    }

    @Override
    public List<Car> findCarByStatus(List<Car> carList, int idCarStatus) {
        List<Car> cars = new ArrayList<>();
        for (Car car1 : carList) {
            if (car1.getStatus().getId() == idCarStatus) {
                cars.add(car1);
            }
        }
        return cars;
    }

    @Override
    public List<Car> findCarByType(List<Car> carList, int idType) {
        List<Car> cars = new ArrayList<>();
        for (Car car1 : carList) {
            if (car1.getType().getIdType() == idType) {
                cars.add(car1);
            }
        }
        return cars;
    }


}
