package com.at.base;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StringOne {

    public ArrayList<String> bufferReader(Path path){
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String str = null;
            while ((str = reader.readLine()) != null){
                System.out.println(str);
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void bufferWriter(Path out, List<String> contents){
        BufferedWriter writer = null;
        try {
            // FileWriter fileWriter = new FileWriter("D:\\aa.txt", true);
            // writer = new BufferedWriter(fileWriter);
            // 简化写法
            writer = Files.newBufferedWriter(out, StandardCharsets.UTF_8);
            for (String content: contents) {
//                writer.write(content);   // 传入的字符串不可以为null，会报错
                writer.append(content);   // 可以传null，会转成字符串null
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scannerSystemIn() {
        // 输入
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入:");
            String s = in.next();
            System.out.println("请输入2：");
            String s2 = in.next();
            // 没有则创建
            PrintWriter out = new PrintWriter("sysIn.txt", StandardCharsets.UTF_8.toString());
            out.write(s + s2);
            out.close();
            in.next();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scannerFile(Path path){
        try {
            Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name());
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                System.out.println(next);
            }
            System.out.println("scanner file end!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.printf("%tF \n", new Date());
        System.out.printf("%tF %<tT \n", new Date());
        String property = System.getProperty("user.dir");
        System.out.println(property);
        Path root = Paths.get(System.getProperty("user.dir"));
        Path rPath = Paths.get(root.toString(),"br.txt");

        StringOne one = new StringOne();
        ArrayList<String> strings = one.bufferReader(rPath);
        strings.add(null);
        strings.add("end");

        Path bwPath = Paths.get(root.toString(), "bw.txt");
        one.bufferWriter(bwPath, strings);

        System.out.println("_________________");
        one.scannerFile(rPath);
    }
    public void compare(){
        String str8 = "";
        long freeMemory = Runtime.getRuntime().freeMemory();  // 获取当前系统剩余内存
        long now = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            str8 = str8 + i; // 相当于产生5000个对象
        }
        long freeMemory1 = Runtime.getRuntime().freeMemory();
        long curr = freeMemory1 - freeMemory;
        System.out.println("使用内存" + (curr - now));
    }
}
