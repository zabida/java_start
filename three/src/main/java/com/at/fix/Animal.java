package com.at.fix;

public class Animal {
    private String category;
    private String location;

    Animal() {}

    Animal(String category, String location) {
        this.category = category;
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Animal("1", "2");
    }
}
