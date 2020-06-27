package lc41;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2020/6/27
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().firstMissingPositive2(new int[]{1000,-5}));
//        System.out.println(new Solution().firstMissingPositive2(new int[]{1,2,0}));
        System.out.println(new Solution().firstMissingPositive2(new int[]{3,4,1,-1}));

    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (v <= nums.length) {
                nums[v - 1] = -Math.abs(nums[v - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }


    public int firstMissingPositive2(int[] nums) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            while(nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i]-1]){
                int t=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[t-1]=t;
            }
        }

        for (int i=0;i<n;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }

        return n+1;
    }
}
