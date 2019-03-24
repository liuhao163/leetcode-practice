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

    public void push(String s) {
        if (count == size) {
            System.out.println("full");
            return;
        }
        arr[count] = s;
        count++;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String ret = arr[count - 1];
        count--;
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
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.push("d");
        arrayStack.push("e");
        arrayStack.push("f");
        arrayStack.push("g");
        arrayStack.push("h");
        arrayStack.push("i");
        arrayStack.push("j");
        arrayStack.push("k");
        arrayStack.push("l");

        System.out.println(arrayStack);

        while (!arrayStack.isEmpty()) {
            System.out.print(arrayStack.pop() + ",");
        }

        System.out.println(arrayStack);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        arrayStack.push("6");
        arrayStack.push("7");
        arrayStack.push("8");
        arrayStack.push("9");
        arrayStack.push("10");
        arrayStack.push("11");
        arrayStack.push("12");

        System.out.println(arrayStack);

    }
}
