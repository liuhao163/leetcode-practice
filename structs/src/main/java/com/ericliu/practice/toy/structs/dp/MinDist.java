package com.ericliu.practice.toy.structs.dp;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/29
 */
public class MinDist {
    private static int[][] metrix = new int[][]{{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};

    /**
     * 示例中的动态表法：
     * 1.我们先初始化第一行和第一列的值
     * 2.根据stats[i-1][j]向下走和stats[i][j-1]向右走，找到最短距离，其他的值丢弃
     * 3.遍历stats[n-1],即最后一行找到最短距离
     *
     * @param metrix 是矩阵，
     * @return
     */
    public static int minDist(int[][] metrix) {
        int w = metrix.length;
        int h = metrix.length;
        int[][] stats = new int[w][h];

        //初始化第一行和第一列
        //第一行1，1+3，1+3+5，1+3+5+9
        //第一列1，1+2，1+2+5，1+2+5+6
        stats[0][0] = 1;
        for (int i = 1; i < w; i++) {
            stats[i][0] += stats[i - 1][0] + metrix[i][0];
        }
        for (int j = 1; j < h; j++) {
            stats[0][j] += stats[0][j - 1] + metrix[0][j];
        }

        //推导状态转移
        for (int i = 1; i < w; i++) {
            for (int j = 1; j < metrix[i].length; j++) {
                //stats[i-1][j]向下走-->stats[i - 1][j]+ metrix[i][j]
                int down = Integer.MAX_VALUE;
                if (stats[i - 1][j] > 0) {
                    down = stats[i - 1][j] + metrix[i][j];
                }

                //stats[i][j-1]向右走-->stats[i][j - 1]+ metrix[i][j]
                int right = Integer.MAX_VALUE;
                if (stats[i][j - 1] > 0) {
                    right = stats[i][j - 1] + metrix[i][j];
                }

                //找最小值
                int min = right < down ? right : down;
                if (min != Integer.MAX_VALUE) {
                    stats[i][j] = min;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stats[w - 1].length; i++) {
            if (stats[w - 1][i] > 0 && stats[w - 1][i] < min) {
                min = stats[w - 1][i];
            }
        }

        if (min != Integer.MAX_VALUE) {
            return min;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(MinDist.minDist(metrix));
    }
}
