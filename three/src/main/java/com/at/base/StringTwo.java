package com.at.base;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

public class StringTwo {
    public static void main(String[] args) {
        String a = "123456as哎";
        System.out.println(a.substring(0,5));
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(a.getBytes(StandardCharsets.UTF_8));
        String s1 = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8));
        String s = Arrays.toString(encode);
        System.out.println(a);
        System.out.println(s1);
//        Long b = null;
//        boolean b1 = b.equals(1L);
//        System.out.println(b1);

        String aaa = UUID.randomUUID().toString().replace("-", "");
        System.out.println(aaa + "---" + aaa.length());
        System.out.println(aaa.substring(9));
    }
}
