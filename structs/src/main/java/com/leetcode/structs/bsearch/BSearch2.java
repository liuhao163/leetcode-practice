package com.leetcode.structs.bsearch;

/**
 * @Author: liuhaoeric
 * Create time: 2019/04/02
 * Description:
 */
public class BSearch2 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 6, 7, 7, 7, 8, 8, 8, 9, 10, 11, 12, 23, 56, 78, 99, 222, 222, 333, 444, 555, 666, 777, 888};


        searchFirstEq(a, 8);
        searchLastEq(a, 8);
        searchRecentLte(a, 77);
        searchRecentGte(a, 77);

        a = new int[]{5, 1, 2, 3, 4};
        int target = 1;
        System.out.println(searchLoopArray(a, target));
    }

    private static int searchLoopArray(int[] a, int d) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            if (a[l] == d) {
                return l;
            }

            if (a[h] == d) {
                return h;
            }

            int m = l + ((h - l) >> 1);
            if (a[m] == d) {
                return m;
            }

            if (a[m] > a[l]) {
                if (d > a[m]) {
                    l = m + 1;
                } else {
//                    d<a[m]
                    if (d > a[l]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                // a[m]<a[l]

                if (d < a[m]) {
                    h = m - 1;
                } else {
                    if (d > a[h]) {
                        h = m - 1;
                    } else {
                        //d<a[h]
                        l = m + 1;
                    }
                }
            }


        }

        return -1;
    }


    public static int searchLastEq(int a[], int d) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            int m = l + ((h - l) >> 1);
            if (a[m] > d) {
                h = m - 1;
            } else if (a[m] < d) {
                l = m + 1;
            } else {
                //注意找最后一个eq所以如果相等就判断后一位是否相等如果不相等返回，如果相等，说明要取的值在右边，l=m+1
                if (m == a.length - 1 || a[m + 1] != d) {
                    System.out.printf("最后个相等%s的Index=%s,v=%s\n", d, m, a[m]);
                    return m;
                }
                l = m + 1;
            }
        }

        System.out.println("最后一个相等的没找到");
        return -1;
    }

    public static int searchFirstEq(int a[], int d) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            int m = l + ((h - l) >> 1);
            if (a[m] > d) {
                h = m - 1;
            } else if (a[m] < d) {
                l = m + 1;
            } else {
                //注意找第一个eq所以如果相等就判断前一位是否相等如果不相等返回，如果相等，说明要取的值在左边，h=m-1
                if (m == 0 || a[m - 1] != d) {
                    System.out.printf("第一个相等%s的Index=%s,v=%s\n", d, m, a[m]);
                    return m;
                }
                h = m - 1;
            }
        }

        System.out.println("第一个相等的没找到");
        return -1;
    }

    /**
     * ..a[m]...6,7,d,9.....-->7
     *
     * @param a
     * @param d
     * @return
     */
    public static int searchRecentLte(int a[], int d) {
        int l = 0;
        int h = a.length;

        while (l <= h) {
            int m = l + ((h - l) >> 1);

            //如题，找d左边的第一值，当a[m]<=d的时候说明m在左边，然后一直往右边找，直到找到后面大于d的返回，
            // 如果右边依然<=d，说明要找的值还在右边，二分法l=m+1
            // 如果a[m]>d，不符合条件说明要找的值在m的左边，需要h=m-1
            if (a[m] <= d) {
                if (m == 0 || a[m + 1] > d) {
                    System.out.printf("最后(最近的小于等于)小于等于%s的数的(Index=%s,v=%s)\n", d, m, a[m]);
                    return m;
                }
                l = m + 1;
            } else {
                h = m - 1;
            }

        }
        return -1;
    }

    /**
     * .....6,7,d,9..a[m]...-->9
     *
     * @param a
     * @param d
     * @return
     */
    public static int searchRecentGte(int a[], int d) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            int m = l + ((h - l) >> 1);
            //如题：找d右边的第一个值，如果a[m]>=d，要一直向左找，找到m==0或者m的左边小于d的数，返回m
            // 如果a[m-1]依然大于d，说明要照的数在左边，h=m-1
            // 如果a[m]<d，说明要照的数在右边，l=m+1
            if (a[m] >= d) {
                if (m == 0 || a[m - 1] < d) {
                    System.out.printf("第一个(最近的大于等于)大于等于%s的数的(Index=%s,v=%s)\n", d, m, a[m]);
                    return m;
                }
                h = m - 1;
            } else {
                //a[m]<d
                l = m + 1;
            }

        }

        return -1;
    }


}
