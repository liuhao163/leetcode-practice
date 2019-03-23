package com.leetcode.structs.stack;

import java.util.Arrays;

/**
 * @Author: liuhaoeric
 * Create time: 2019/03/23
 * Description:
 */
public class ArrayStack {

    private int size = 0;
    private String[] arr;
    private int count = 0;

    public ArrayStack(int size) {
        this.size = size;
        arr = new String[size];
    }

    public void enter(String s) {
        if (count == size) {
            System.out.println("full");
            return;
        }
        arr[count] = s;
        count++;
    }

    public String out() {
        if (count == 0) {
            return null;
        }
        String ret = arr[count - 1];
        count--;
//        arr = Arrays.copyOf(arr, count, String[].class);
        return ret;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    @Override
    public String toString() {
        return "ArrayStack{" +
                "size=" + size +
                ", arr=" + Arrays.toString(Arrays.copyOf(arr, count, String[].class)) +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.enter("a");
        arrayStack.enter("b");
        arrayStack.enter("c");
        arrayStack.enter("d");
        arrayStack.enter("e");
        arrayStack.enter("f");
        arrayStack.enter("g");
        arrayStack.enter("h");
        arrayStack.enter("i");
        arrayStack.enter("j");
        arrayStack.enter("k");
        arrayStack.enter("l");

        System.out.println(arrayStack);

        while (!arrayStack.isEmpty()) {
            System.out.print(arrayStack.out() + ",");
        }

        System.out.println(arrayStack);
        arrayStack.enter("1");
        arrayStack.enter("2");
        arrayStack.enter("3");
        arrayStack.enter("4");
        arrayStack.enter("5");
        arrayStack.enter("6");
        arrayStack.enter("7");
        arrayStack.enter("8");
        arrayStack.enter("9");
        arrayStack.enter("10");
        arrayStack.enter("11");
        arrayStack.enter("12");

        System.out.println(arrayStack);

    }
}
