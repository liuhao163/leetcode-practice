package com.ericliu.practice.toy.structs.queue;

import java.util.Arrays;

/**
 * @Author: liuhaoeric
 * Create time: 2019/03/24
 * Description:
 */
public class DymanicArrayQueue {
    private String[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public DymanicArrayQueue(int size) {
        this.size = size;
        array = new String[size];
    }

    public void enque(String s) {
        if (tail == size) {
            int newSize = size * 2;
            String[] newArray = new String[newSize];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[head + i];
            }
            tail = size;
            size = newSize;
            array = newArray;
        }

        array[tail] = s;
        tail++;
    }

    public String dequeue() {
        if (head == tail) {
            head=0;
            tail=0;
            return null;
        }
        String ret=array[head];
        head++;

        return ret;
    }

    public String[] getArray() {
        return array;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + Arrays.toString(array) +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        DymanicArrayQueue dymanicArrayQueue = new DymanicArrayQueue(10);
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.println("===>" + dymanicArrayQueue);
            }
            dymanicArrayQueue.enque(String.valueOf(i));
        }

        System.out.println(dymanicArrayQueue);

        String ret=null;
        while ((ret=dymanicArrayQueue.dequeue())!=null){
            System.out.println("dequeue=====>"+ret);
        }

        System.out.println("dequeue=====>"+dymanicArrayQueue.dequeue()+",queue="+dymanicArrayQueue);
        System.out.println("dequeue=====>"+dymanicArrayQueue.dequeue()+",queue="+dymanicArrayQueue);
        for (int i = 0; i < 100; i++) {
            dymanicArrayQueue.enque(String.valueOf("new"+i));
        }
        System.out.println("dequeue=====>"+dymanicArrayQueue.dequeue()+",queue="+dymanicArrayQueue);
        System.out.println("dequeue=====>"+dymanicArrayQueue.dequeue()+",queue="+dymanicArrayQueue);
    }
}
