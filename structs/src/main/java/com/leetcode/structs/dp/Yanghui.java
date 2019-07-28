package com.leetcode.structs.dp;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/28
 */
public class Yanghui {
   static int[][] matrix = {{5}, {7, 8}, {2, 3, 4}, {4, 9, 6, 1}, {2, 7, 9, 4, 5}};
    int n = 5;

    public int shortDir() {
        n = 5;
        int state[][] = new int[5][5];
        state[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            int v = -1;
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (state[i - 1][j] > 0) {
                    if (v < -1 || v < state[i - 1][j] + matrix[i][j]) {
                        v = state[i - 1][j] + matrix[i][j];
                    }
                    state[i][j] = v;
                }
            }
        }

        int min = 0;
        for (int j = 0; j < 5; j++) {
           if(min==0 || min<state[4][j]){
               min=state[4][j];
           }
        }
        return min;
    }

    public static void main(String[] args) {
        Yanghui yanghui=new Yanghui();

        System.out.println(yanghui.shortDir());
    }
}
