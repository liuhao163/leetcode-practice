package com.leetcode.structs.sorts;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/27
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90, 91, 0, 3, 5, 7, 8, 9, 5, 21, 3, 56, 6, 5, 653, 2};
        new QuickSort().sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int a[], int start, int end) {
        if (start >= end) {
            return;
        }

        int poivt = getPoivt(a, start, end);

        sort(a, start, poivt-1);
        sort(a, poivt, end);

        return;
    }

    private int getPoivt(int[] a, int start, int end) {
        int r = a[end];

        int swap = start;
        for (int i = start; i <= end-1; i++) {
            if (a[i] <= r) {
                int tmp = a[swap];
                a[swap] = a[i];
                a[i] = tmp;

                swap++;
            }
        }

        int tmp=a[swap];
        a[swap]=a[end];
        a[end]=tmp;
        return swap;
    }
}
