package com.ericliu.practice.toy.testlist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liuhaoeric
 * Create time: 2020/02/10
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        List<Person> l1=new ArrayList<>();
        l1.add(new Person());
        l1.add(new Person());
        l1.get(0).setName("liuhao");
        l1.get(1).setName("nicole");
        System.out.println(l1);
        System.out.println();
        System.out.println();
        List<Person> l2= l1.stream().filter(p->p.getName().equals("liuhao")).collect(Collectors.toList());
        System.out.println(l2);
        l2.get(0).setAge(100);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(l1);
    }
}
