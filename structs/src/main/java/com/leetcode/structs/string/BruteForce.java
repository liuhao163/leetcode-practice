package com.leetcode.structs.string;

import java.util.Arrays;

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

    public static int[] test(char[][] main, char[][] pattern) {
        int pxlen = pattern.length;
        int pylen = pattern[0].length;
        for (int i = 0; i < main.length - pxlen + 1; i++) {
            for (int j = 0; j < main[i].length - pylen + 1; j++) {
                char a = main[i][j];
                boolean eq = true;
                for (int k = 0; k < pattern.length; k++) {
                    for (int k1 = 0; k1 < pattern[k].length; k1++) {
                        if (main[i + k][j + k1] != pattern[k][k1]) {
                            eq = false;
                            break;
                        }
                    }
                }

                if (eq) {
                    return new int[]{i, j};
                }


//                String mains = new String(new char[]{main[i][i], main[i][i], main[i][j], main[j][i], main[j][j]});
//                String ps = new String(new char[]{pattern[i][i], pattern[i][i], pattern[i][j], pattern[j][i], pattern[j][j]});
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnklmn";
        String p1 = "klmn";
        BruteForce bf = new BruteForce(s, p1);
        int i = bf.indexOf();
        System.out.println(i);
        for (int idx = i; idx < i + p1.length(); idx++) {
            System.out.print(s.charAt(idx));
        }
        System.out.println();

        char[][] main = new char[4][4];

        main[0][0] = 'd';
        main[0][1] = 'a';
        main[0][2] = 'b';
        main[0][3] = 'c';
        main[1][0] = 'e';
        main[1][1] = 'f';
        main[1][2] = 'a';
        main[1][3] = 'd';
        main[2][0] = 'c';
        main[2][1] = 'c';
        main[2][2] = 'a';
        main[2][3] = 'f';
        main[3][0] = 'd';
        main[3][1] = 'e';
        main[3][2] = 'f';
        main[3][3] = 'c';

        char[][] pattern = new char[2][2];
        pattern[0][0] = 'c';
        pattern[0][1] = 'a';
        pattern[1][0] = 'e';
        pattern[1][1] = 'f';


        System.out.println("作业======暴力破解法找矩阵");
        int[] ret = test(main, pattern);
        System.out.println(Arrays.toString(ret));
        for (int k = ret[0]; k < ret[0] + 2; k++) {
            for (int k1 = ret[1]; k1 < ret[1] + 2; k1++) {
                System.out.print(main[k][k1]);
            }
            System.out.println();
        }
    }
}
