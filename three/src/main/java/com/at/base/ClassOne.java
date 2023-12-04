package com.at.base;

import com.chinadep.common.util.AESUtil;

import java.util.Date;

public class ClassOne {

    public static void main(String[] args) {
       // Animal animal = Animal.class.cast(Obj);
        Date date = new Date(1612312345 * 1000L);
        System.out.println(date);

        String encrypt = AESUtil.encrypt("1234");
        System.out.println(encrypt);
        String decrypt = AESUtil.decrypt(encrypt);
        System.out.println(decrypt);
//         List<Integer> list = Arrays.asList(1, 2, 3, 4);
//         String[] a = {"1", "2"};
//         String[] b = {"1", "2"};
//         System.out.println(Arrays.toString(a));
//         String[] strings = ArrayUtil.addAll(a, b);
//         System.out.println(Arrays.toString(strings));
    }
}
