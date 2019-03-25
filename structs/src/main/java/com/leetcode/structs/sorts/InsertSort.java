package com.leetcode.structs.sorts;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/25
 */
public class InsertSort {
    public int[] sort(int[] array) {

        //从数组第二个开始循环排序，第一项作为已排序区域
        for (int i = 1; i < array.length; i++) {
            //value临时变量，为当前待排序元素
            int value = array[i];


            int j = i - 1;
            //从排序区域最后一位开始往前循环直到第一位。
            //如果遇到array>value，反之，因为是已排序区，所以直接break跳出循环
            //做数据搬迁array[j+1]=array，
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    //数据搬迁array[j+1]=array[j]，因为j的起始值是i-1，所以搬迁范围范围是[0,i]
                    array[j + 1] = array[j];
                } else {
                    //因为是已排序区，所以直接break跳出循环
                    break;
                }
            }
            //因为跳出循环时候,做了一次j--所以。
            array[j+1] = value;
        }

        return array;
    }

    public static void main(String[] args) {

        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90};

        System.out.println(Arrays.toString(new InsertSort().sort(array)));
    }
}
