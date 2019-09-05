package com.ericliu.practice.toy;

import java.util.*;

/**
 * @Author: liuhaoeric
 * Create time: 2019/08/16
 * Description:
 */
public class ThreeSum {


    public static List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > 0) {
                break;
            }
            if (a[i] == a[i + 1]) {
                continue;
            }

            int l = i+1;
            int r = a.length - 1;

            while (r > l) {
                if (a[i] + a[l] + a[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a[i]);
                    list.add(a[l]);
                    list.add(a[r]);
                    ret.add(list);

                    while (r > l && a[l] == a[l + 1]) {
                        l++;
                    }
                    while (r > l && a[r] == a[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (a[l] + a[r] + a[i] > 0) {
                    r--;
                } else if (a[l] + a[r] + a[i] < 0) {
                    l++;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = ThreeSum.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});

        System.out.println(list);
    }
}
