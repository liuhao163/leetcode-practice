package com.leetcode.structs.heap;

import java.util.Arrays;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/1
 */
public class TestHeap {

    public static void main(String[] args) {
        Heap heap = new Heap(14);
        heap.insert(33);
        heap.insert(27);
        heap.insert(21);
        heap.insert(16);
        heap.insert(13);
        heap.insert(15);
        heap.insert(19);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.insert(12);
//        System.out.println(heap);
//        heap.insert(22);
//        System.out.println("==after insert 22== 0,33,17,22");
//        System.out.println(heap);

//        System.out.println("==delTop==0,27,16,21");
//        heap.delTop();
//        System.out.println(heap);

        int array[] = new int[]{
                0, 7, 5, 19, 8, 4, 1, 20, 13, 16
        };
        System.out.println(Heap.buildHeap(array,9));

        System.out.println(Arrays.toString(Heap.sort(array)));
    }

}
