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

    private void sort(int[] a, int s, int e) {
        if (s >= e) {
            return;
        }

        int poivt = poivt(a, s, e);
        sort(a, s, poivt - 1);//todo 重点
        sort(a, poivt, e);//todo 重点
    }

    private int poivt(int[] a, int s, int e) {
        int swapIdx = s;
        int r = a[e];

        for (int i = s; i <= e - 1; i++) {//重点
            if (a[i] <= r) {//todo 重点
                int tmp = a[i];
                a[i] = a[swapIdx];
                a[swapIdx] = tmp;
                swapIdx++;//扩大
            }
        }

        int tmp = a[swapIdx];
        a[swapIdx] = r;
        a[e] = tmp;

        return swapIdx;
    }


}
