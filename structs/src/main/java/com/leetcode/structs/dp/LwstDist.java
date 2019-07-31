package com.leetcode.structs.dp;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/30
 * Description:
 */
public class LwstDist {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;


    private int ret = Integer.MAX_VALUE;

    private void lwstBT(int i, int j, int edist) {
        if (i == a.length || j == b.length) {
            if (i < a.length) {
                edist += (a.length - i);
            }
            if (j < b.length) {
                edist += (a.length - j);
            }

            if (edist < ret) {
                ret = edist;
            }

            return;
        }

        if (a[i] == b[j]) {
            lwstBT(i + 1, j + 1, edist);
        } else {
            lwstBT(i, j + 1, edist + 1);
            lwstBT(i + 1, j, edist + 1);
            lwstBT(i + 1, j + 1, edist + 1);
        }
    }

    private int lwstDP() {
        int states[][] = new int[6][6];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (i == 0) {
                    states[0][j] = j;
                } else if (j == 0) {
                    states[i][0] = i;
                }
            }
        }
        //i==j  min(i,j)=min(min(i-1,j)+1,min(i,j-1)+1,min(i-1,j-1))
        //i!=j  mint(i,j)=(min(i-1,j)+1,min(i,j-1)+1,min(i-1,j-1)+1)
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    states[i][j] = min(states[i - 1][j] + 1, states[i][j - 1] + 1, states[i - 1][j - 1]);
                } else {
                    states[i][j] = min(states[i - 1][j] + 1, states[i][j - 1] + 1, states[i - 1][j - 1] + 1);
                }
            }
        }

        return states[5][5];
    }

    private int min(int... x) {
        int min = Integer.MAX_VALUE;
        for (int a : x) {
            min = min < a ? min : a;
        }
        return min;
    }

    ///////////
    private int lcsRet = Integer.MIN_VALUE;

    private void lcsBT(int i, int j, int lcs) {
        if (i == a.length || j == b.length) {
            if (lcs > lcsRet) {
                lcsRet = lcs;
            }

            return;
        }


        if (a[i] == b[j]) {
            lcsBT(i+1, j+1, lcs + 1);
        } else {
            lcsBT(i+1, j, lcs);
            lcsBT(i, j+1, lcs);
        }
    }


    public int lcsDP() {
        int states[][] = new int[6][6];
        for (int j = 0; j < b.length; j++) {
            if (a[0] == b[j]) {
                states[0][j] = 1;
            } else if (j != 0) {
                states[0][j] = states[0][j - 1];
            } else {
                states[0][j] = 0;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                states[i][0] = 1;
            } else if (i != 0) {
                states[i][0] = states[i - 1][0];
            } else {
                states[i][0] = 0;
            }
        }

        // i==j states(i，j)=max(states(i-1,j),states(i,j-1),states[i - 1][j - 1] + 1)
        // i!=j states(i，j)=max(states(i-1,j),states(i,j-1))
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    states[i][j] = max(states[i - 1][j], states[i][j - 1], states[i - 1][j - 1] + 1);
                } else {
                    states[i][j] = max(states[i - 1][j], states[i][j - 1], states[i - 1][j - 1]);
                }
            }
        }

        return states[5][5];

    }

    private int max(int... x) {
        int max = Integer.MIN_VALUE;
        for (int a : x) {
            max = a > max ? a : max;
        }
        return max;
    }

    public static void main(String[] args) {
        LwstDist l = new LwstDist();
//        l.lwstBT(0, 0, 0);
//
//        System.out.println(l.ret);
//
//        System.out.println(l.lwstDP());

        System.out.println(l.lcsDP());


        l.lcsBT(0, 0, 0);
        System.out.println(l.lcsRet);
    }
}
