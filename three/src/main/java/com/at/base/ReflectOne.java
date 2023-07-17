package com.at.base;

import lombok.Data;

import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.util.HashMap;


@Data
class Student{
    int age;
    String sex;
}


public class ReflectOne {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // forName的方式
        Class<?> aClass = Class.forName("com.at.base.Student");
        System.out.println(aClass.hashCode());

        Class<Student> aClass1 = Student.class;
        System.out.println(aClass1.hashCode());

        Student student = new Student();
        Class<? extends Student> aClass2 = student.getClass();
        System.out.println(aClass2.hashCode());
        // 发现打印出来的hash值都是一样的

        // 内置的包装类都有一个TYPE属性
        Class<Integer> aClass3 = Integer.TYPE;
        System.out.println(aClass3);

        Class<Object> aClass4 = Object.class;
        Class<Comparable> aClass5 = Comparable.class;
        Class<String[]> aClass6 = String[].class;
        Class<int[][]> aClass7 = int[][].class;
        Class<Override> aClass8 = Override.class;
        Class<ElementType> aClass9 = ElementType.class;
        Class<Integer> aClass10 = Integer.class;
        Class<Void> aClass11 = void.class;
        Class<Class> aClass12 = Class.class;

        Student o = (Student) aClass.newInstance();

        o.age = 12;
        o.sex = "nan";
        System.out.println(o);
        HashMap<String, Field> map = new HashMap<>();

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            map.put(field.getName(), field);
        }

        Field age = map.get("age");
        int i = (int) age.get(o);
        System.out.println(i);

        for (Field field : Student.class.getDeclaredFields()) {
            map.put(field.getName(), field);
        }
        Field sex = map.get("sex");
        String s = (String) sex.get(o);
        System.out.println(s);
    }
}
