package com.leetcode.structs.dp;

/**
 * 0,1背包问题，动态规划求解
 *
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/28
 */
public class Package1 {

    private static int[] weight = new int[]{2, 2, 4, 6, 3};
    private static int n = 5;
    private static int w = 9;

    //时间复杂度是w*n，空间复杂度也是w*n因为采用了二维数组
    public void knapsack(int[] weight, int w, int n) {
        //二位数组:一维是n的值，二维是w+1的值
        boolean[][] state = new boolean[n][w + 1];

        state[0][0] = true;
        if (weight[0] <= w) {
            state[0][weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            //根据上一个的结果进行推断

            //不放在背包中: 如果上一个是true，这次不放，这次也还是true(和上一次状态一样)
            //state[i - 1][j]-->state[i][j]=true
            for (int j = 0; j <= w; j++) {
                if (state[i - 1][j]) {
                    state[i][j] = state[i - 1][j];
                }
            }

            //放在背包中: 如果上一个是true，这次放,注意这时候循环终止条件是w-weight[i]
            //state[i - 1][j]-->state[i][j+weight[i]]=true
            for (int j = 0; j <= w - weight[i]; j++) {
                if (state[i - 1][j]) {
                    state[i][j + weight[i]] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (state[i][j]) {
                    System.out.println("i=" + i + "j=" + j + "w=" + state[i][j]);
                }
            }
        }
    }

    //用一维数组
    public void knapsack1(int[] weight, int w, int n) {
        //二位数组:一维是n的值，二维是w+1的值
        boolean[] state = new boolean[w + 1];

        state[0] = true;
        if (weight[0] <= w) {
            state[weight[0]] = true;
        }


        for (int i = 1; i < n; i++) {
            //这里需要倒叙循环，
            // 如果正序循环，因为 state[j + weight[i]]=true改变了state值，所以在本次循环运行到这里时候会造成干扰
            for (int j = w - weight[i]; j >= 0; j--) {
                if (state[j]) {
                    state[j + weight[i]] = true;
                }
            }
        }

        for (int i = 0; i < w + 1; i++) {
            if (state[i]) {
                System.out.println("i=" + i + ",w=" + state[i]);
            }

        }
    }


    public static void main(String[] args) {
        Package1 package1 = new Package1();
        package1.knapsack(weight, w, n);
        System.out.println();
        System.out.println();
        package1.knapsack1(weight, w, n);
    }
}
