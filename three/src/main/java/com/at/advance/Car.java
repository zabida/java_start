package com.at.advance;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Car {

    private String engine;
    private String series;
    public Car(){}

    Car(String e, String series){
        this.engine = e;
        this.series = series;
    }

    public void ready(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("休眠1秒" + this.series);
    }

    public static ArrayList<Car> createCars(int n){
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i< n; i++){
            cars.add(new Car("", String.valueOf(i)));
        }
        return cars;
    }
}
