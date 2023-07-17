package com.at.base;

import com.at.base.pclass.Account;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class AnnotationTest {

    public static void main(String[] args) {

        Account asa = new Account(19, "asa");
        Annotation[] annotations = asa.getClass().getDeclaredAnnotations();
        System.out.println(Arrays.toString(annotations));
        Annotation[] annotations1 = asa.getClass().getAnnotations();
        System.out.println(Arrays.toString(annotations1));
    }
}
