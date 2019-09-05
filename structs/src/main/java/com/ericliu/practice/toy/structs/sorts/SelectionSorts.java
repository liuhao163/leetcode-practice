package com.ericliu.practice.toy.structs.sorts;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/26
 */
public class SelectionSorts {

    /**
     * 选择排序，循环数组，每次都找到数组最小值，然后和当前元素互换位置，知道结束，
     * 时间负责度最好O(n*n)，最坏O(n*n)，平均都是O(n*n)，且不稳定
     *
     * @param a
     * @return
     */
    public int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {

            //记录最小值和索引
            int min = a[i];
            int minIdx = i;

            //循环查找最小值
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIdx = j;
                }
            }

            //如果当前值不是最小值，最小值和当前值互换位置
            if (i != minIdx) {
                a[minIdx] = a[i];
                a[i] = min;
            }
        }

        return a;
    }

    public static void main(String[] args) {

        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90};

        System.out.println(Arrays.toString(new SelectionSorts().sort(array)));
    }
}
