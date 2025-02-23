package A_leetcode.面试150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.abs;

public class No219 {
    public static void main(String[] args) {

        int [] nums = {1,2,3,1,2,3};
        int k  = 3;
            System.out.println(containsNearbyDuplicate2(nums, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int  i=0;i< nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else {
              if (Math.abs(i-map.get(nums[i]))<=k){
                  return true;
              }else {
                  map.put(nums[i],i);
              }
            }
        }
        return false;
    }


    public static boolean containsNearbyDuplicate2(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        int length=nums.length;
        for(int i=0;i<nums.length;i++){
          if (set.contains(nums[i])){
              return true;
          }else {
              set.add(nums[i]);
          }
          if (i-k>=0){
              set.remove(nums[i-k]);
          }
        }
        return false;
    }
}
