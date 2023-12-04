package com.at.base;

import com.chinadep.common.util.AESUtil;
import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionOne {
    public static void main(String[] args) {
        // 先声明再初始化
        String[] s1 = new String[3];
        s1[0] = "s1_0";
        s1[2] = "s1_2";
        System.out.println(ArrayUtil.arrayToString(s1));

        // 声明并初始化
        String[] s2 = {"s2_1", "s2_2", "s2_3"};
        System.out.println(Arrays.toString(s2));

        String[] s3 = new String[]{"s3_1", "s3_2", "s3_3"};
        System.out.println(Arrays.toString(s3));

        ArrayList<String> s4 = new ArrayList<>();
        s4.add("s4_4");
        s4.add("s4_1");
        s4.add("s4_3");
        Collections.sort(s4);  // 排序
        System.out.println("s4 排列后" + s4);
        List<String> strings = Collections.checkedList(s4, String.class);
        System.out.println("strings is" + strings);


        ArrayList<String> s5 = new ArrayList<>();
        s5.add("s5_1");
        s5.add("s5_2");
        s5.addAll(s4);
        Collections.reverse(s5);  // 翻转
        System.out.println("s5 is " + s5);

        Collections.fill(s5, "11");  // 重新填充，全部替换填充为 11
        System.out.println("s5 is" + s5);
        List<String> li1 = Arrays.asList("li_1", "li_2", "li_3");
        // 不可以用add，这个生成的是不可变长的列表，返回的是final，注意
//        li1.add("s1");
        System.out.println(li1);
        // Arrays.asList还有很多注意的地方，咋一看很诡异的地方

        // 这个可以添加add
        List<String> li1_ = Stream.of("a", "b").collect(Collectors.toList());
        li1_.add("2");
        System.out.println(li1_);
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

        System.out.println("li3:" + li3);
        ArrayList<String> li3_ = new ArrayList<>();
        li3.forEach(s -> {
            li3_.add(s + "kk");
        });
        System.out.println("li3_:" + li3_);
        List<String> li3__ = li3.stream().map(i -> i + "kk").collect(Collectors.toList());
        System.out.println("li3__:" + li3__);

        String kk = li3.stream().max((u1, u2) -> {
            return u1.length() - u2.length();
        }).orElse("kk");
        System.out.println("kk: " + kk);

//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return (s1.compareTo(s2));
//            }
//        });

        String[] players = {"aa", "bb", "ac", "ab"};

        // 这里是要返回对象，是一种简写方法，箭头后面要加小括号，不加小括号，就当作{}代码块执行了，
        // 其实是 (String a, String b) -> { return a.compareTo(b); }的简写。
        Comparator<String> sortByName = (String a, String b) -> (a.compareTo(b));
//        Comparator<String> sortByName = String::compareTo;
        Arrays.sort(players, sortByName);
        System.out.println(Arrays.toString(players));
        List<String> list = Arrays.asList(players);
        List<String> strings1 = list.subList(0, 10);
        System.out.println(strings1);

    }
}
