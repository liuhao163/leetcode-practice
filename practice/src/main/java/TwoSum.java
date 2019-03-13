import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuhaoeric
 * Create time: 2018/09/20
 * Description:
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] towSumByHash(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int res=target-nums[i];
            if(map.containsKey(res)){
                return new int[]{i,map.get(res)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 11, 15};
        System.out.println(towSumByHash(nums, 17)[0] + " " + towSumByHash(nums, 17)[1]);
    }
}
