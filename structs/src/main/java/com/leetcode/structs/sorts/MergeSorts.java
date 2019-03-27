package com.leetcode.structs.sorts;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/27
 */
public class MergeSorts {

    public static void main(String[] args) {
        int[] array = new int[]{80, 3, 9, 8, 9, 77, 35, 78, 90, 91, 0, 3, 5, 7, 8, 9, 5, 21, 3, 56, 6, 5, 653, 2};
        new MergeSorts().sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int a[], int start, int end) {
        if (start >= end) {
            return;
        }

        //利用分治思想递归
        int mid = (start + end) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    private void merge(int[] a, int start, int mid, int end) {
        //临时数组等于a里start-->end
        int[] tmp = new int[end - start + 1];//注意：一定是end-start+1，因为这是Index,长度要+1（0--2长度是3）
        int k = 0;

        //给tmp赋值，逻辑是i从start-->mid，j从mid+1-->end
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            tmp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }

        //剩余补进临时数组
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }

        //将临时数据写入到a中
        for (int x = 0; x < tmp.length; x++) {
            a[start + x] = tmp[x];
        }
    }


}
