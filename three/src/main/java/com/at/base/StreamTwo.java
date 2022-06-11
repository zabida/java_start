package com.at.base;

import java.io.*;
import java.util.Scanner;

public class StreamTwo {

    public static void bufferedInputStream() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        int temp = 0;
        try {
            fis = new FileInputStream("1.txt");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("bw2.txt");
            bos = new BufferedOutputStream(fos);
            while ((temp = bis.read()) != -1) {
                System.out.println(temp);
                bos.write(temp);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void bufferedReader(){
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String tempStr = "";
        try {
            fr = new FileReader("reader.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("writer.txt");
            bw = new BufferedWriter(fw);
            while ((tempStr = br.readLine()) != null) {
                System.out.println(tempStr);
                bw.write(tempStr);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null) {
                    fw.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        while (scanner.hasNext()){
            String next = scanner.next();
            System.out.println(next);
            float v = Float.parseFloat(next);
            System.out.printf("%,.2f", v);
            System.out.println("----");
        }
        String s = String.format("%babc%s", Boolean.FALSE, "test");
        System.out.println(s);
    }

    public static void main(String[] args) {
//        bufferedInputStream();
        bufferedReader();
    }
}
