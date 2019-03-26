package com.leetcode.structs.sorts;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/26
 */
public class SelectionSorts {

    public int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIdx = i;
            int min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    minIdx = j;
                    min=a[j];
                }
            }

            if (i != minIdx) {
                int tmp=a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
            }

        }
        return a;
    }

    public static void main(String[] args) {

        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90};

        System.out.println(Arrays.toString(new SelectionSorts().sort(array)));
    }
}
