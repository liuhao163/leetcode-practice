package com.leetcode.structs.bsearch;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 二分查找法
 *
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/4/1
 */
public class BSearch {

    //递归
    public int search(int[] a, int dest) {
        int low = 0;
        int high = a.length - 1;
        if (low >= high) {
            return a[high] == dest ? high : -1;
        }

        return search(a, low, high, dest);
    }

    private int search(int[] a, int low, int high, int dest) {
        int mid = low + ((high - low) >> 1);
        if (a[mid] > dest) {
            return search(a, low, mid - 1, dest);
        } else if (a[mid] < dest) {
            return search(a, mid + 1, high, dest);
        } else {
            return mid;
        }
    }

    public int searchByLoop(int[] a, int dest) {
        int low = 0;
        int high = a.length - 1;
        if (low >= high) {
            return a[low] == dest ? low : -1;
        }


        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (a[mid] == dest) {
                return mid;
            } else if (a[mid] > dest) {
                high = mid - 1;
            } else if (a[mid] < dest) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public double squart(double x, int n) {
        double l = 1;
        double h = x;
        if (x > 0 && x < 1) {
            l = 0;
            h = 1;
        }

        if (x == 0 || x == 1) {
            return x;
        }

        long base = 1;
        int i = 1;
        while (i <= n) {
            base = base * 10;
            i++;
        }
        double ret = squart(x, l, h, 1.00f/base);

        return new BigDecimal(ret).setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private double squart(double x, double l, double h, float p) {
        if (h - l <= p) {
            return l;
        }

        double m = l + (h - l) / 2;
        if (m * m > x) {
            return squart(x, l, m - p, p);
        } else if (m * m < x) {
            return squart(x, m + p, h, p);
        } else {
            return m;
        }
    }


    //    public double sqart(double x, String pString) {
//        if (x == 0) {
//            return 0;
//        }
//        if (x == 1) {
//            return 1;
//        }
//
//        double low = 0.0;
//        double high = 0.0;
//
//        if (x > 0 && x < 1) {
//            low = 0;
//            high = 1;
//        } else {
//            low = 1;
//            high = x;
//        }
//
//        double precision=Double.parseDouble(pString);
//
//        double ret = sqart(x, low, high, precision);
//
//
//
//        return new BigDecimal(ret).setScale(pString.length()-2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
//    }
//
//    private double sqart(double x, double low, double high, double precision) {
//        double mid = low + (high - low) / 2;
//        if (high - low <= precision) {
//            return mid;
//        }
//        if (mid * mid == x) {
//            return mid;
//        } else if (mid * mid > x) {
//            return sqart(x, low, mid, precision);
//        } else {
//            return sqart(x, mid, high, precision);
//        }
//    }
//
//    public int searchByLoop(int a[], int dest) {
//        int low = 0;
//        int high = a.length - 1;
//
//        if (high == low) {
//            return a[high] == dest ? high : -1;
//        }
//
//        while (high - low >= 0) {
//            int mid = low + ((high - low) >> 1);
//            if (a[mid] == dest) {
//                return mid;
//            } else if (a[mid] < dest) {
//                low = mid + 1;
//            } else {
//                // if(a[mid]>dest)
//                high = mid - 1;
//            }
//        }
//
//        return -1;
//    }
//
//
//    public int searchByRecursion(int a[], int low, int high, int dest) {
//        if (low >= high) {
//            return a[low] == dest ? low : -1;
//        }
//
//        int mid = low + ((high - low) >> 1);
//
//        if (a[mid] < dest) {
//            return searchByRecursion(a, mid + 1, high, dest);
//        } else if (a[mid] > dest) {
//            return searchByRecursion(a, low, mid - 1, dest);
//        } else {
//            return mid;
//        }
//    }
//
    public static void main(String[] args) {
        int a[] = new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        System.out.println(new BSearch().searchByLoop(a, 4));

        System.out.println(new BSearch().search(a, 4));

        System.out.println(new BSearch().squart(7, 15));
    }


}
