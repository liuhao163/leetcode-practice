package com.ericliu.practice.toy.structs.dp;

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
            int v = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (state[i - 1][j] > 0) {
                    if (state[i - 1][j] + matrix[i][j] < v ) {
                        v = state[i - 1][j] + matrix[i][j];
                    }
                    state[i][j] = v;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 5; j++) {
           if(state[4][j]!=0&& state[4][j]<min){
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
