package com.at.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class IteratorOne {
    private void test(){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1,2,3,4,5,6,7".split(","));
        System.out.println(list); // [1,2,3,4,5,6,7]
        // list转成迭代器也是可遍历的一种方式
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if(next.startsWith("3")) {
                iterator.remove();  // [1,2,4,5,6,7]
            }
        }
        // 以上可以简化成
        list.removeIf(next -> {return next.startsWith("3");});
        list.removeIf(next -> next.startsWith("3"));
        System.out.println(list);
    }

    public static void main(String[] args) {
        new IteratorOne().test();
    }
}
