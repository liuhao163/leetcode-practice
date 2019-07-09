package com.leetcode.structs.string;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/09
 * Description:暴力匹配算法
 */
public class BruteForce {
    private char[] main;
    private char[] pattern;


    public BruteForce(String main, String pattern) {
        this.main = main.toCharArray();
        this.pattern = pattern.toCharArray();
    }

    //暴力搜索的方法，总共有起始位置0，1，2，...n,m-n+1个子串，每个子串和摩串匹配时间复杂度是O(m-n)
    public int indexOf() {
        if (main.length < pattern.length) {
            return -1;
        }
        boolean eq = true;
        for (int i = 0; i <= main.length - pattern.length + 1; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (main[i + j] != pattern[j]) {
                    eq = false;
                    break;
                }
                eq = true;
            }

            if (eq) {
                return i;
            }
        }
        return -1;
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
