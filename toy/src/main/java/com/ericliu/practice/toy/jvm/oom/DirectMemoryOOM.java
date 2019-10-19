package com.ericliu.practice.toy.jvm.oom;

/**
 * @Author: liuhaoeric
 * Create time: 2019/10/17
 * Description:
 */


import sun.misc.Unsafe;

import java.lang.reflect.Field;


/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final int MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];

        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(MB);
        }
    }
}
