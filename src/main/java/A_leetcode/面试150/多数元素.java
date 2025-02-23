package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 多数元素 {
    public static void main(String[] args) {
        int [] nums = new int[]{ 3,2,3};

    }
    public static int majorityElement(int[] nums) {
        int ans = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
                if (map.get(nums[i])>count){
                    ans = nums[i];
                    count = map.get(nums[i]);
                }
            }
        }
       return ans;
    }
}
