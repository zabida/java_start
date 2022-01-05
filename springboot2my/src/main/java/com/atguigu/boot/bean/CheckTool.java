package com.atguigu.boot.bean;

import com.atguigu.boot.anonotation.Check;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class CheckTool {
    public static void main(String[] args) throws IOException {
        Calculator c = new Calculator();
        int m = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method mot : c.getClass().getMethods()) {
            if (mot.isAnnotationPresent(Check.class)) {
                try {
                    mot.invoke(c, 1, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                    m++;
                    bw.write(mot.getName() + "异常");
                    bw.newLine();
                    bw.write("异常名称:" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因:" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("=====================");
                    bw.newLine();
                }
            }
        }
        bw.write("一共出现"+ m + "次异常");
        System.out.println("结束");
        bw.flush();
        bw.close();
    }
}
