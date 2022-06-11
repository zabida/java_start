package com.at.base;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class StreamThree {

    public static void fileUtils() throws IOException {
//        String gbk = FileUtils.readFileToString(new File("1.txt"), "gbk");
        String gbk = FileUtils.readFileToString(new File("1.txt"), "utf8");
        System.out.println(gbk);
    }

    public static void fileUtilsCopy() throws IOException {
        // 拷贝文件夹，并且FileFilter里 返回true是部分也会拷贝过去
        FileUtils.copyDirectory(new File("d:/dep"), new File("d:/deps"), new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || pathname.getName().endsWith("html")) {
                    return Boolean.TRUE;
                } else return false;
            }
        });
    }

    public static void ioUtils() throws IOException {
        String s = IOUtils.toString(new FileInputStream("1.txt"), "gbk");
        System.out.println(s);
    }

    public static void main(String[] args) {
        try {
            fileUtils();
            fileUtilsCopy();
            ioUtils();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
