package com.at.fix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StreamOne {

    public static void read1() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("1.txt");
            int data;
            // 一个一个读,返回的是char对应的数字，最后没有了返回-1
            while ((data=stream.read()) != -1) {
                System.out.println((char) data);
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read2(){
        FileInputStream stream = null;
        try {
            // 定义一个1024长度的数组
            byte[] b = new byte[5];
            stream = new FileInputStream("1.txt");
            int available = stream.available();
            // stream.read(b),读出数组b长度的字节出来，并放入b中;读得出来返回放入数组的个数，读完了读不出来时返回0
            int num=stream.read(b);
            System.out.println("文件的字节长度是：" + available);
            System.out.println("读出来放入b中的个数是" + num);
            System.out.println("b是");
            for (byte value : b) {
                System.out.print((char) value);
            }
            System.out.println("");
            // 继续读
            int available1 = stream.available();
            int num1 = stream.read(b);
            System.out.println("第二次文件的字节长度是：" + available1);
            System.out.println("第二次读出来放入b中的个数是" + num1);
            System.out.println("现在b是");
            for (byte va: b) {
                System.out.print((char) va);
            }
            System.out.println("");

            // 继续读读看
            int available2 = stream.available();
            int num2 = stream.read(b);
            System.out.println("第三次文件的字节长度是：" + available2);
            System.out.println("第三次读出来放入b中的个数是" + num2);
            System.out.println("现在b是");
            for (byte va: b) {
                System.out.print((char) va);
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(){
        try {
            // 覆盖写
            // FileOutputStream stream = new FileOutputStream("");
            // 追加写
            FileOutputStream stream = new FileOutputStream("a.txt", true);
            String s = "java写文件";
//            stream.write(s.getBytes(StandardCharsets.UTF_8));
            stream.write(s.getBytes(StandardCharsets.UTF_8), 0, 2);  // len不可以超过字符串长度
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        write();
        read2();
    }
}
