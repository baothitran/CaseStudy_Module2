package com.codegym.comparator;

import com.codegym.model.Car;

import java.util.Comparator;

public class ComparatorIncreasingByPrice implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getRentalPrice()>o2.getRentalPrice()){
            return 1;
        }
        else if (o1.getRentalPrice()==o2.getRentalPrice()){
            return 0;
        }
        else return -1;
    }
}