package com.leetcode.structs.sorts;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/25
 */
public class InsertSort {
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j+1] = array[j ];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90};

        System.out.println(Arrays.toString(new BubbleSort().sort(array)));
    }
}
