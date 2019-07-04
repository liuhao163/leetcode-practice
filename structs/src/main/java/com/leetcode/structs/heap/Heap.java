package com.leetcode.structs.heap;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/1
 */
public class Heap {

    private int array[];
    private int count = 0;
    private int capacity;

    public Heap(int capacity) {
        this.array = new int[capacity];
        this.capacity = array.length;
    }

    public int[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void insert(int value) {
        if (count == capacity) {
            System.out.println("堆已经满了");
            return;
        }

        array[count] = value;
        int i = count;
        count++;
        while (i > 0) {
            int pIdx = (i - 1) / 2;
            if (array[i] > array[pIdx]) {
                swap(array, i, pIdx);
            }
            i = pIdx;
        }
    }

    //删除堆顶
    public void delTop() {
        //删空了
        if (count == 0) {
            return;
        }

        //为了防止空洞直接，将最后一位数据和堆顶交换，删除最后一位数据，然后将新的堆顶自上而下的堆化
        array[0] = array[count - 1];
        array[count - 1] = 0;
        count--;
        heapify(array, count - 1, 0);
    }

    public static void buildHeap(int a[]) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, a.length - 1, i);
        }
    }


    public static int[] sort(int a[]) {
        buildHeap(a);
        System.out.println("buildHeap=" + Arrays.toString(a));

        int swapIdx = a.length - 1;
        while (swapIdx > 0) {
            swap(a, swapIdx, 0);
            swapIdx--;
            heapify(a, swapIdx, 0);
        }

        return a;
    }

    //堆化操作
    private static void heapify(int[] a, int heapCapicity, int i) {
        while (true) {
            int tmp = i;
            if (2 * i + 1 <= heapCapicity && a[tmp] < a[2 * i + 1]) {
                tmp = 2 * i + 1;
            }
            if (2 * (i + 1) <= heapCapicity && a[tmp] < a[2 * (i + 1)]) {
                tmp = 2 * (i + 1);
            }
            if (tmp == i) {
                break;
            }
            swap(a, i, tmp);
            i = tmp;
        }
    }

    private static void swap(int array[], int idxA, int idxB) {
        int tmp = array[idxA];
        array[idxA] = array[idxB];
        array[idxB] = tmp;
    }


    @Override
    public String toString() {
        return "Heap{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                ", capacity=" + capacity +
                '}';
    }
}
