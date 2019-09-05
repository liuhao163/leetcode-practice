package com.ericliu.practice.toy.structs.string;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/22
 * Description:
 */
public class KMP {
    private char[] str;
    private char[] ptr;

    public KMP(String str, String ptr) {
        this.str = str.toCharArray();
        this.ptr = ptr.toCharArray();
    }

    public int search() {
        int i = 0;
        int j = 0;
        int[] next = getNext(ptr);

        while (i < str.length && j < ptr.length) {
            if (j == -1 || str[i] == ptr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == ptr.length) {
            return i - j;
        }
        return -1;
    }

    private int[] getNext(char[] ptr) {
        int[] next = new int[ptr.length];
        next[0] = -1;

        int i = 0;
        int j = -1;
        while (i < ptr.length - 1) {
            if (j == -1 || ptr[i] == ptr[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "ababaeababacdbac";
        String ptr = "ababacd";
        int idx = new KMP(str, ptr).search();
        System.out.println("idx=" + idx + ", string=" + str.substring(idx, idx + ptr.length()));
    }
}
