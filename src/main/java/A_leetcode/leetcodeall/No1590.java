package A_leetcode.leetcodeall;

import java.util.HashMap;

public class No1590 {

    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{3,1,4,2}, 6));
    }
    public static int minSubarray(int[] nums, int p) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int aim = 0;
        for(int i = 0;i<nums.length;i++){
            aim = (aim+(nums[i]))%p;
        }
        if (aim==0){
            return 0;
        }
        int ans = nums.length;
        int cur=0;
        for(int i = 0;i<nums.length;i++){
            cur = (cur+nums[i])%p;
            map.put(cur,i);
            if(map.containsKey((p+cur-aim)%p)){
                ans = Math.min(ans,i-map.get((p+cur-aim)%p));
            }
        }
        if(ans == nums.length){
            return -1;
        }else{
            return ans;
        }
    }
}
