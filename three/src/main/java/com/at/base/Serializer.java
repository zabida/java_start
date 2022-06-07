package com.at.base;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;


public class Serializer implements Serializable {
    public String name;
    public String address;
    public Integer asb;

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream outputStream = new FileOutputStream("./he.txt");
    }
}

