package com.leetcode.structs.recursion;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/25
 */
public class Fibonacci {

    public int cal(int n){
        if(n==1 || n==2){
            return 1;
        }

        return cal(n-1)+cal(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().cal(5));
    }
}
