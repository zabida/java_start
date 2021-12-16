package com.at.fix;

public class Fan2<T> {
    private T fan;

    public T getFan() {
        return fan;
    }

    public void setFan(T fan) {
        this.fan = fan;
    }

    public void add(T fan) {
        String s = this.fan.toString() + fan.toString();
        System.out.println(s);
    }

    public static void main(String[] args) {
        Fan2<String> fan2 = new Fan2<>();
        fan2.setFan("fan2");
        fan2.add("yi_ge");
    }
}
