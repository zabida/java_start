package com.at.fix;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class StringOne {
    public static void main(String[] args) {
        System.out.printf("%tF", new Date());
        System.out.printf("%tc", new Date());
        Path path = Paths.get("1.txt", "utf-8");

        try {
            Scanner scanner = new Scanner(path);
            String s = scanner.next();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
