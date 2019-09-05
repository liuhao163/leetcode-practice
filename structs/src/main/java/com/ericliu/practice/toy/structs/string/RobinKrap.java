package com.ericliu.practice.toy.structs.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/09
 * Description:
 */
public class RobinKrap {
    private char[] main;
    private char[] pattern;

    private Integer patternHash;

    private Map<Integer, Integer> hashMap = new HashMap<>();

    //本质和bf的方法一样，只是预先将0~m-n个n-m+1个子串的hash和位置预先计算出来保存起来，然后在查询时候用模的hash去匹配看是否存在
    public RobinKrap(String main, String pattern) {
        this.main = main.toCharArray();
        this.pattern = pattern.toCharArray();

        patternHash = this.pattern.hashCode();

        for (int i = 0; i < main.length() - pattern.length() + 1; i++) {
            hashMap.put(Arrays.copyOfRange(this.main, i, pattern.length()).hashCode(), i);
        }
    }


    public int indexOf() {
        return hashMap.containsKey(patternHash)?hashMap.get(patternHash):-1;
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnklmn";
        String p = "klmn";
        BruteForce bf = new BruteForce(s, p);
        int i = bf.indexOf();
        System.out.println(i);
        for (int idx = i; idx < i + p.length(); idx++) {
            System.out.print(s.charAt(idx));
        }
        System.out.println();
    }

}
