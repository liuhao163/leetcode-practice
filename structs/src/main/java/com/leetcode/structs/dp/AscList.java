package com.leetcode.structs.dp;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/31
 * Description:
 */
public class AscList {
    private static int[] array = new int[]{2, 9, 3, 6, 5, 1, 7};

    int max = Integer.MIN_VALUE;

    public void getAscBT(int m, int n, int[] array, int ascLen) {
        if (m == array.length || n == array.length) {
            if (ascLen > max) {
                max = ascLen;
            }
            return;
        }

        if (array[m] < array[n]) {
            getAscBT(m + 1, n + 1, array, ascLen + 1);
        } else {
            getAscBT(m + 1, n + 1, array, ascLen);
            getAscBT(m, n + 1, array, ascLen);
        }
    }

    public int getAscDP(int[] array) {
        int state[][] = new int[array.length][array.length];
        state[0][0] = 1;


        for(int j=1;j<array.length;j++){
            if(array[0]<array[j]){
                state[0][j]=2;
            }
            state[0][j]=1;
        }


        for(int i=1;i<array.length;i++){
            if(array[i]<array[0]){
                state[i][0]=2;
            }
            state[i][0]=1;
        }


        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    state[i][j] = state[i - 1][j - 1] + 1;
                } else {
                    state[i][j] =Math.max(state[i][j - 1],state[i-1][j - 1]) ;
                }
            }
        }

        return state[array.length-1][array.length-1];
    }



    public static void main(String[] args) {
        AscList ascList = new AscList();
        ascList.getAscBT(0, 1, AscList.array, 1);
        System.out.println(ascList.max);


        System.out.println(ascList.getAscDP(AscList.array));

    }
}
