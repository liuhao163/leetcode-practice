package com.ericliu.practice.toy.structs.sorts;

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

    /**
     * 获取数组的一个标志位（交换区点一般是数组最后一位，小于这个点的在左边，大于的在右边）
     *
     * @param a
     * @param s
     * @param e
     */
    private void sort(int[] a, int s, int e) {
        if (s >= e) {
            return;
        }

        int poivt = poivt(a, s, e);
        sort(a, s, poivt - 1);//排序取到分区点后，分区点-1，参与排序
        sort(a, poivt, e);//从分区点到终点排序
    }

    private int poivt(int[] a, int s, int e) {
        int swapIdx = s;//交换区为s，随着数组循环移动
        int flag = a[e];//设置flag即最后交换区

        //s-->e-1,循环到交换区前
        for (int i = s; i <= e - 1; i++) {
            //即时小于也要交换，让swpIdx后移
            if (a[i] <= flag) {
                int tmp = a[i];
                a[i] = a[swapIdx];
                a[swapIdx] = tmp;
                swapIdx++;//扩大前半部分
            }
        }

        //最后将flag移动到此次poivt点并且返回交换区点
        int tmp = a[swapIdx];
        a[swapIdx] = flag;
        a[e] = tmp;

        return swapIdx;
    }

}
