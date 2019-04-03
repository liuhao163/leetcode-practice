package lc33;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/4/3
 */
public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{7, 0, 1, 2, 3, 4, 5, 6};
        int target = 6;
        System.out.println(search(a, target));
    }

    public static int search(int[] a, int d) {
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
            if (a[m] > l) {
                if (a[m] < d) {
                    l = m + 1;
                } else {
//                    a[m]>d
                    if (a[l] < d) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
//                a[m]<l;
                if (a[l] < d) {
                    l = m + 1;
                } else {
                    if (a[h] > d) {
                        l = m + 1;
                    } else {
//                        a[h]<d
                        h = m - 1;
                    }
                }
            }
        }


        return -1;
    }

}
