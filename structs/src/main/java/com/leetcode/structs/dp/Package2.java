package com.leetcode.structs.dp;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/28
 */
public class Package2 {
    private static int[] items = new int[]{2, 2, 4, 6, 3};
    private static int[] value = new int[]{3, 4, 8, 9, 6};
    private static int n = 5;
    private static int w = 9;

    public int knapsack(int[] items, int[] value, int w, int n) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[i].length; j++) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        if (items[0] <= w) {
            states[0][items[0]] = value[0];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] > 0) {
                    states[i][j] = states[i - 1][j];
                }
            }

            for (int j = 0; j <= w - items[i]; j++) {
                if (states[i - 1][j] > -1) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i - 1][j]) {
                        states[i][j + items[i]] = v;
                    }
                }
            }
        }

        int max = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > max) {
                max = states[n - 1][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new Package2().knapsack(items, value, w, n);
        System.out.println(i);
    }
}
