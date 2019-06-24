package lc4;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/4/8
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums1.length + nums2.length];
        int x = 0;
        int i = 0;
        int j = 0;

        boolean isOld = false;
        if ((tmp.length & 1) == 0) {
            isOld = true;
        }

        int mid = tmp.length / 2;
        while (i < nums1.length && j < nums2.length) {
            tmp[x++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            if(x==mid+1){
                break;
            }
        }
        while (i < nums1.length) {
            tmp[x++] = nums1[i++];
            if(x==mid+1){
                break;
            }
        }

        while (j < nums2.length) {
            tmp[x++] = nums2[j++];
            if(x==mid+1){
                break;
            }
        }


        if (isOld) {
            return ((double) tmp[mid - 1] + (double) tmp[mid]) / 2;
        } else {
            return (double) tmp[mid];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
