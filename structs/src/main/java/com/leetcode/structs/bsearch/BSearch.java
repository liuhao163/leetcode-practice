package com.leetcode.structs.bsearch;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 二分查找法
 *
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/4/1
 */
public class BSearch {

    public double sqart(double x, String pString) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        double low = 0.0;
        double high = 0.0;

        if (x > 0 && x < 1) {
            low = 0;
            high = 1;
        } else {
            low = 1;
            high = x;
        }

        double precision=Double.parseDouble(pString);

        double ret = sqart(x, low, high, precision);



        return new BigDecimal(ret).setScale(pString.length()-2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    private double sqart(double x, double low, double high, double precision) {
        double mid = low + (high - low) / 2;
        if (high - low <= precision) {
            return mid;
        }
        if (mid * mid == x) {
            return mid;
        } else if (mid * mid > x) {
            return sqart(x, low, mid, precision);
        } else {
            return sqart(x, mid, high, precision);
        }
    }

    public int searchByLoop(int a[], int dest) {
        int low = 0;
        int high = a.length - 1;

        if (high == low) {
            return a[high] == dest ? high : -1;
        }

        while (high - low >= 0) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == dest) {
                return mid;
            } else if (a[mid] < dest) {
                low = mid + 1;
            } else {
                // if(a[mid]>dest)
                high = mid - 1;
            }
        }

        return -1;
    }


    public int searchByRecursion(int a[], int low, int high, int dest) {
        if (low >= high) {
            return a[low] == dest ? low : -1;
        }

        int mid = low + ((high - low) >> 1);

        if (a[mid] < dest) {
            return searchByRecursion(a, mid + 1, high, dest);
        } else if (a[mid] > dest) {
            return searchByRecursion(a, low, mid - 1, dest);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11};

        System.out.println(new BSearch().searchByLoop(a, 4));

        System.out.println(new BSearch().searchByRecursion(a, 0, a.length - 1, 4));

        System.out.println(new BSearch().sqart(79, "0.000001"));
    }


}
