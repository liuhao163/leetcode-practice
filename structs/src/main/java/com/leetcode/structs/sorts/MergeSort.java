package com.leetcode.structs.sorts;

import java.util.Arrays;

/**
 * @Author: liuhaoeric
 * Create time: 2019/03/26
 * Description:
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90};
        new MergeSort().mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid+1, high);

        //排序逻辑
        merge(a, low, mid, high);
    }

    public void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        int[] tmp = new int[high-low+1];
        int tmpIdx = 0;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                tmp[tmpIdx++] = a[i++];
            } else {
                tmp[tmpIdx++] = a[j++];
            }
        }

        while (i <= mid) {
            tmp[tmpIdx++] = a[i++];
        }
        while (j <= high) {
            tmp[tmpIdx++] = a[j++];
        }

        for (int ret = 0; ret < tmp.length; ret++) {
            a[ret+low] = tmp[ret];
        }
    }
}
