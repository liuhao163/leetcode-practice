package lc41;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2020/6/27
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().firstMissingPositive(new int[]{1000,-5}));
//        System.out.println(new Solution().firstMissingPositive(new int[]{1,2,0}));
        System.out.println(new Solution().firstMissingPositive(new int[]{1}));

    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (v <= nums.length) {
                nums[v - 1] = -Math.abs(nums[v-1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;//
            }
        }

        return nums.length+1;
    }
}
