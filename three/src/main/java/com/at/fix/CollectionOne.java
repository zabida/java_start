package com.at.fix;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionOne {
    public static void main(String[] args){
        // 先声明再初始化
        String[] s1 = new String[3];
        s1[0]="s1_0";
        s1[2]="s1_2";
        System.out.println(ArrayUtil.arrayToString(s1));

        // 声明并初始化
        String[] s2 = {"s2_1", "s2_2", "s2_3"};
        System.out.println(Arrays.toString(s2));

        String[] s3 = new String[]{"s3_1", "s3_2", "s3_3"};
        System.out.println(Arrays.toString(s3));

        ArrayList<String> s4 = new ArrayList<>();
        s4.add("s4_1");
        s4.add("s4_2");
        s4.add("s4_3");
        System.out.println(s4);

        ArrayList<String> s5 = new ArrayList<>();
        s5.add("s5_1");
        s5.add("s5_2");
        s5.addAll(s4);
        System.out.println(s5.size());

        List<String> li1 = Arrays.asList("li_1", "li_2", "li_3");
        // 不可以用add，这个生成的是不可变长的列表
        // li1.add("s1");
        System.out.println(li1);
        // 这个可以添加add
        List<String> s6 = Stream.of("a", "b").collect(Collectors.toList());
        // li2
        ArrayList<String> li2 = new ArrayList<>();
        Collections.addAll(li2, "1", "2", "3");
        System.out.println(li2);

        ArrayList<String> li3 = new ArrayList<>(Arrays.asList("aa,bbb,cc".split(",")));
        System.out.println(Arrays.toString(li3.toArray()));

        List<String> li4 = li3.stream().map(num -> num + 1).collect(Collectors.toList());
        System.out.println(li4);

        List<String> l4 = li3.stream().filter(s -> !s.startsWith("a")).collect(Collectors.toList());
        System.out.println(l4);

        li3.forEach(s -> {
            s = s + "kk";
        });
        System.out.println(li3);

        String kk = li3.stream().max((u1, u2) -> {
            return u1.length() - u2.length();
        }).orElse("kk");
        System.out.println(kk);
    }
}
