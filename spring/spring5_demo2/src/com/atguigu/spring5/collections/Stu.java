package com.atguigu.spring5.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    private String[] courses;
    private List<String> list;
    private Map<String, String> maps;
    private Set<String> sets;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void testDemo(){
        System.out.println(Arrays.toString(courses));
//        System.out.println(courses);
        System.out.println(list);
        System.out.println(maps);
        System.out.println(sets);
    }
}
