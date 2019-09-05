package com.ericliu.practice.toy.structs.queue;

import java.util.Arrays;

/**
 * @Author: liuhaoeric
 * Create time: 2019/03/24
 * Description:
 */
public class CircleQueuqe {
    private String[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public CircleQueuqe(int size) {
        this.size = size;
        array = new String[size];
    }

    public void enque(String s) {
        //尾指针下一个指向head队列满
        if ((tail + 1) % size == head) {
            throw new RuntimeException("CircleQueuqe has full");
        }

        array[tail] = s;
        //环状的下一个位置是 tail+1取模
        tail = (tail + 1) % size;
    }

    public String deques() {
        if(head==tail){
            throw new RuntimeException("CircleQueuqe has empty");
        }

        String ret=array[head];
        head=(head+1)%size;

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
        return "CircleQueuqe{" +
                "array=" + Arrays.toString(array) +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CircleQueuqe queue=new CircleQueuqe(10);
        for (int i = 0; i < 9; i++) {
            queue.enque(String.valueOf(i));
        }
        System.out.println(queue);
        for (int i = 0; i < 9; i++) {
            System.out.println(queue.deques());
        }
        System.out.println(queue);
        for (int i = 0; i < 9; i++) {
            queue.enque(String.valueOf("new"+i));
        }
        System.out.println(queue);
        queue.deques();
        queue.enque("liuhao");
        System.out.println(queue);
        for (int i = 0; i < 9; i++) {
            System.out.println("======>"+queue.deques());
        }
    }
}
