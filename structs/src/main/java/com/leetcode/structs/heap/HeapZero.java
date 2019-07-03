package com.leetcode.structs.heap;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/1
 */
public class HeapZero {

    private int array[];
    private int count = 0;
    private int capacity;

    public HeapZero(int capacity) {
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
            int pIdx=(i - 1) / 2;
            if (array[i] > array[pIdx]) {
              swap(array,i,pIdx);
            }
            i=pIdx;
        }
    }

    //删除堆顶
    public void delTop() {
        if (count == 0) {
            return;
        }
        count--;
        array[0] = array[count];
        array[count] = 0;
        heapify(array, count, 0);
    }

    public static void buildHeap(int array[]) {
        for (int k = array.length / 2 - 1; k >= 0; k--) {
            heapify(array, array.length - 1, k);
        }
        System.out.println("array buildHeap:" + Arrays.toString(array));
    }


    public static int[] sort(int array[]) {
        buildHeap(array);

        int swapIdx = array.length - 1;

        while (swapIdx > 0) {
            swap(array, 0, swapIdx);
            swapIdx--;
            heapify(array, swapIdx, 0);
        }
        return array;
    }

    //堆化操作
    private static void heapify(int[] array, int heapCapicity, int i) {
        while (true) {
            int top = i;
            if (2 * i + 1 <= heapCapicity && array[top] < array[2 * i + 1]) {
                top = 2 * i + 1;
            }

            if (2 * (i + 1) <= heapCapicity && array[top] < array[2 * (i + 1)]) {
                top = 2 * (i + 1);
            }

            if (top == i) {
                break;
            }
            swap(array, top, i);
            i = top;
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
