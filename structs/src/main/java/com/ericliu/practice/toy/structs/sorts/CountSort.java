package com.ericliu.practice.toy.structs.sorts;

import java.util.Arrays;

/**
 * @Author: liuhaoeric
 * Create time: 2019/03/31
 * Description:
 */
public class CountSort {

    public int[] sort(int[] a) {
        //查找最大值
        int max = getMax(a);
        int[] countArray = new int[max + 1];

        //分桶（申请一个数组），从0---max每个值一个桶，并且做累加
        for (int i = 0; i < a.length; i++) {
            countArray[a[i]] = countArray[a[i]] + 1;
        }

        System.out.println(Arrays.toString(countArray));

        //遍历桶给桶做累加，记录从min-->max，每个值包含他之前的值总共有多少个，用于后面的排序
        int sum = countArray[0];
        for (int i = 1; i < countArray.length; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        System.out.println(Arrays.toString(countArray));

        //申请额外空间
        int[] ret=new int[a.length];
        //轮询要排序数组a,a的值就是桶的下标。
        // 1.找到a[i]在countArray中对应的count值；
        // 2.这个(count-1)值对应的是排序之后数组的该值的index，将a[i]插入到新数组的ret[count-1]
        // 3.count--;
        for (int i = 0; i < a.length; i++) {
            int v = a[i];
            int count = countArray[v]-1;
            ret[count] = v;
            countArray[v] =count;
        }

        return ret;
    }

    private int getMax(int[] a) {
        int ret = a[0];
        for (int i = 1; i < a.length; i++) {
            if (ret <= a[i]) {
                ret = a[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90, 91, 0, 3, 5, 7, 8, 9, 5, 21, 3, 56, 6, 5, 653, 2};
        System.out.println(Arrays.toString(new CountSort().sort(array)));

    }
}
