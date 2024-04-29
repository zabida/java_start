package com.at.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOne {

    public static void main(String[] args) {
        ArrayList<Car> cars = Car.createCars(100);
        List<Car> collect = cars.stream().filter(x -> {
            int integer = Integer.parseInt(x.getSeries());
            if (integer > 20){
                x.ready();
                return true;
            }
            return false;
        }).skip(30).limit(3).collect(Collectors.toList());
        System.out.println(collect);
    }
}
