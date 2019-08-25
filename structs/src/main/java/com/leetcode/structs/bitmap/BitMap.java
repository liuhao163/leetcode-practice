package com.leetcode.structs.bitmap;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/8/4
 */
public class BitMap {
    private int[] bytes;
    private int total;

    //int类型的位图下标是4个字节即32bit
    public BitMap(int total) {
        this.bytes = new int[total / 32 + 1];
        this.total = total;
    }

    public void set(int value) {
        //找到数组下标
        int index = value / 32;
        //通过摩运算找到偏移量
        int bit = value % 32;
        //通过位运算|找到值
        bytes[index] |= 1 << bit;
    }

    public boolean exists(int value) {
        if (value > total) {
            return false;
        }

        int index = value / 32;
        int bit = value % 32;
        return (bytes[index] & 1 << bit) != 0;
    }

    public void sort() {
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((bytes[i] & (1 << j)) != 0) {
                    System.out.print((i*32+j) + " ");
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        BitMap bm = new BitMap(100);
        bm.set(1);
        bm.set(2);
        bm.set(5);
        bm.set(10);
        bm.set(11);
        bm.set(95);
        bm.set(100);
        bm.sort();
    }
}
