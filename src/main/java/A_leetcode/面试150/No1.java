package A_leetcode.面试150;

import java.util.*;

public class No1 {


    public static void main(String[] args) {
        int [] nums = {3,2,4};
        System.out.println(twoSum(nums,6));
    }

    public  static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexmaps = new HashMap<>();
        HashMap<Integer,Integer> indexmaps2 = new HashMap<>();
        int [] ans =new int[2];
        for (int i=0;i< nums.length;i++){
            if (indexmaps.containsKey(nums[i])){
                indexmaps2.put(nums[i],i);
            }else {
                indexmaps.put(nums[i],i);
            }
        }
        for (int i =0;i<nums.length;i++){
            if (indexmaps.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = indexmaps.get(target-nums[i]);
                if (ans[0]==ans[1]){
                    continue;
                }
                return ans;
            }
      }
        return ans;
    }
}
