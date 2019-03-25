package com.leetcode.structs.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/25
 */
public class Fibonacci {

    private Map<Integer, Long> map = new HashMap<>();

    /**
     * 递推公式f(n)=f(n-1)+f(n-2)，结果：n==1 return 1 n==2 return 1
     * @param n
     * @return
     */
    public long cal(int n) {
        //递归结果
        if (n == 1 || n == 2) {
            return 1;
        }

        //记录结果避免重复计算
        if (map.containsKey(n)) {
            return map.get(n);
        }

        //计算
        long ret = cal(n - 1) + cal(n - 2);
        map.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        long now=System.currentTimeMillis();
        System.out.println(new Fibonacci().cal(100));

        System.out.println("spent===>"+(System.currentTimeMillis()-now));
    }
}
