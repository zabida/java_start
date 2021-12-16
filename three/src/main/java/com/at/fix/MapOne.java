package com.at.fix;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOne {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>(){{put("a", "b");}};
//        for (String v: map.keySet()) {
//            map.get(v);
//        }
        List<String> list = map.values().stream().map(x -> x + 1).collect(Collectors.toList());
        String s = ArrayUtil.mapToString(map);
        System.out.println(s);
    }
}
