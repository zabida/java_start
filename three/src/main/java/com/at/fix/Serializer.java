package com.at.fix;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

class SerializeDemo {

}


public class Serializer implements Serializable {
    public String name;
    public String address;
    public Integer asb;

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream outputStream = new FileOutputStream("./he.txt");
    }
}

