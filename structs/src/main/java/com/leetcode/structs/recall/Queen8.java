package com.leetcode.structs.recall;

import static sun.misc.Version.print;

/**
 * 八皇后
 *
 * @Author: liuhaoeric
 * Create time: 2019/07/26
 * Description:
 */
public class Queen8 {

    static int[] a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};


    public static void cal8(int row) {
        if (row == 8) {
            printQueen();
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (ok(row, column)) {
                a[row] = column;
                cal8(row + 1);
            }
        }
    }

    private static boolean ok(int row, int column) {

        int leftup = column - 1;
        int rightup = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            if (a[i] == column) {
                return false;
            }

            if (a[i] == leftup) {
                return false;
            }

            if (a[i] == rightup) {
                return false;
            }

            leftup--;
            rightup++;
        }

        return true;
    }

    private static void printQueen() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (a[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("==============");
        System.out.println();
    }


    public static void main(String[] args) {
        cal8(0);
    }


}
