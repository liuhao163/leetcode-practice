package com.ericliu.practice.toy.fab;

/**
 * @Author: liuhaoeric
 * Create time: 2019/10/19
 * Description:
 */
public class Fibonacci {

    public int a = 2;

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int result= fibonacci.fab(1, 1);
        System.out.println(result);

        //number
        System.out.println(fibonacci.a);
    }

    //1,1,2,3
    //    //n-1 n-2
    public int fab(int a, int b) {
        int next = a + b;
        if (next==Integer.MAX_VALUE){
            this.a++;
            return a;
        }
        if (next <= 0) {
            return a;
        }
        this.a++;
        return fab(b, next);
    }
}
