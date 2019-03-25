package com.leetcode.structs.sorts;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/25
 */
public class BubbleSort {

    public int[] sortDesc(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean needBubble=false;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                    needBubble=true;
                }
            }
            if(!needBubble){
                return a;
            }
        }

        return a;
    }

    public int[] sort(int[] array) {
        //第一层循环没循环一次冒泡一次，如果某一次没有发生位置变化说明数组已经完全有序，停止冒泡needBuuble
        for (int i = 0; i < array.length; i++) {
            boolean needBuuble=false;
            for (int j = i + 1; j < array.length; j++) {
                int tmp = array[j];
                if (array[i] > array[j]) {
                    array[j] = array[i];
                    array[i] = tmp;
                    needBuuble=true;
                }
            }
            if(!needBuuble){
                return array;
            }
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = new int[]{80, 3, 4, 8, 9, 100, 101, 102, 103};

        System.out.println(Arrays.toString(new BubbleSort().sortDesc(array)));
    }
}
