package com.leetcode.structs.boomfilter;

/**
 * @Author: liuhaoeric
 * Create time: 2019/08/02
 * Description:
 */
public class BitMap {

    public static void main(String[] args) {
        int bitIndex = 4 % 32;
        System.out.println(1 << bitIndex);

        int byteIndex = 4 / 32;

        int[] a=new int[byteIndex+1];

        a[byteIndex] |= 1 << bitIndex;
        int byteIndex2 = 8 / 32;
        a[byteIndex2] |= 1 << (8 % 32);
        System.out.println(a[byteIndex]);
    }
}
