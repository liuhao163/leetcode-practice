package com.leetcode.structs.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/11
 */
public class BM {

    private Map<Character, Integer> bc = new HashMap<>();

    private char[] s;
    private char[] pattern;


    public BM(char[] s, char[] pattern) {
        this.s = s;
        this.pattern = pattern;

        //init badcode
        for (int i = 0; i < pattern.length; i++) {
            bc.put(pattern[i], i);
        }
    }


    public int search() {

        //初始化好后缀
        int[] suffix = null;
        boolean[] prefix = null;
        suffix = new int[pattern.length];
        prefix = new boolean[pattern.length];

        for (int tmp = 0; tmp <= pattern.length - 1; tmp++) {
            suffix[tmp] = -1;
            prefix[tmp] = false;
        }
        BM.generatorGS(pattern, suffix, prefix);
        System.out.println(Arrays.toString(suffix));
        System.out.println(Arrays.toString(prefix));

        for (int i = 0; i <= s.length - pattern.length; ) {
            int j = pattern.length - 1;
            for (; j >= 0; j--) {
                if (s[i + j] != pattern[j]) {
                    break;
                }
            }

            //匹配完发现了j<0说明全部都符合上面的循环没有break
            if (j < 0) {
                return i;
            }

            /**
             * 滑动的距离 si-xi，即badcode在模串中对应的字符下标-badcode在模串中最后能匹配到的下标（匹配不到为-1）
             *
             * 即：j【在j这里不匹配】-bc(s[i+j])【bc记录的是位置】
             *
             * 滑动的距离实际就是i+j-bc(s[i+j])
             *
             */
            int x = j - getBadCodeIndex(s[i + j]);
            int y = 0;
            if (j < pattern.length - 1) {
                y = moveGS(j, pattern.length, suffix, prefix);
            }
            int ret = Math.max(x, y);
            i = i + ret;
        }
        return -1;
    }

    private int getBadCodeIndex(char c) {
        return bc.get(c) == null ? -1 : bc.get(c);
    }


    /**
     * 预处理好后缀
     * suffeix-->后缀的长度 -- 在模串中最后出现的另一个index（-1说明没有公共后缀）
     * <p>
     * pefix-->后缀的长度 -- 是否同时又是公共前缀（true是false不是）
     * <p>
     * eg cabcab
     * <p>
     * b: 1-->2 false
     * ab: 2-->1 false
     * cab: 3-->0 true
     * bcab: 4-->-1 false
     */
    private static void generatorGS(char[] pattern, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < pattern.length - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && pattern[j] == pattern[pattern.length - 1 - k]) {
                k++;
                suffix[k] = j;
                j--;
            }

            prefix[k] = j < 0;
        }
    }

    /**
     * @param j      坏字符字符在模串中对应的下标，[j+1,m-1]都是好后缀
     * @param m      摩串的长度
     * @param suffix 之前初始化的好后缀长度->另一个字符串初始长度
     * @param prefix 是否是公共前缀
     * @return 默认移动m
     * 如果有公共后缀。即suffix[k]不等于-1，移动j-x+1
     * 如果没有公共后缀，在公共的后缀中找公共前缀，移动公共前缀的长度，返回是[j+2,m-1]
     */
    private static int moveGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;//j-suffix[k]想当于滑动到坏字符，+1是滑动到坏字符后
        } else {
            //为什么是j+2，因为j+1如果是true说明，整个公共后缀同时是公共前缀，不会走到这个分支会走到上面
            for (int i = j + 2; i <= m - 1; i++) {
                int prefixLength = m - i;//m-1-i+1(m-1-i+1 取得的长度没有包含i本身，所以+1)
                if (prefix[prefixLength]) {
                    return i;
                }
            }
        }
        return m;
    }


    public static void main(String[] args) {
        System.out.println(new BM("abcdfge".toCharArray(), "fg".toCharArray()).search());

//        char[] pattern = "cabcab".toCharArray();
//        int[] suffix = null;
//        boolean[] prefix = null;
//        suffix = new int[pattern.length];
//        prefix = new boolean[pattern.length];
//
//        for (int tmp = 0; tmp <= pattern.length - 1; tmp++) {
//            suffix[tmp] = -1;
//            prefix[tmp] = false;
//        }
//        BM.generatorGS("cabcab".toCharArray(), suffix, prefix);
//        System.out.println(Arrays.toString(suffix));
//
//        System.out.println(Arrays.toString(prefix));

    }
}
