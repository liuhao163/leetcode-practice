package com.leetcode.structs.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/25
 */
public class Factorial {
    Map<Long, Long> map = new HashMap<>();

    public Long cal(long n) {
        if (n == 1L) {
            return 1L;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        long ret = cal(n - 1) * n;
        map.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().cal(11));
    }
}
