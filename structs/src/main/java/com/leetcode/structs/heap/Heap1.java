package com.leetcode.structs.heap;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/1
 */
public class Heap1 {

    private int array[];
    private int count = 0;
    private int capacity;

    public Heap1(int capacity) {
        this.array = new int[capacity + 1];
        this.capacity = capacity;
    }

    private Heap1(int[] array) {
        this.array = array;
        this.capacity = array.length - 1;
    }

    public void insert(int value) {
        if (count >= capacity) {
            return;
        }

        count++;
        array[count] = value;

        //堆从后往前
        int i = count;
        while (i / 2 > 0) {
            if (array[i] > array[i / 2]) {
                swap(array, i, i / 2);
            }

            i = i / 2;
        }
    }

    //删除堆顶
    public void delTop() {
        if (count == 0) {
            return;
        }

        array[1] = array[count];
        array[count] = 0;
        count--;
        heapify(array, count, 1);
    }

    public static Heap1 buildHeap(int array[]) {
        for (int i = array.length / 2-1; i >= 1; --i) {
            heapify(array, array.length-1, i);
        }

        return new Heap1(array);
    }

    public static int[] sort(int array[]) {
//        buildHeap(array, array.length - 1);

        int l = array.length - 1;
        while (l > 1) {
            swap(array, 1, l);
            l--;
            heapify(array, l, 1);
        }

        return array;
    }

    //堆化操作
    private static void heapify(int[] array, int heapCapicity, int i) {
        int last = -1;
        while (true) {
            last = i;
            if (i * 2 <= heapCapicity && array[last] <= array[i * 2]) {
                last = i * 2;
            }
            if (i * 2 + 1 <= heapCapicity && array[last] <= array[i * 2 + 1]) {
                last = i * 2 + 1;
            }
            if (i != last) {
                swap(array, last, i);
            } else {
                break;
            }
            i = last;
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
