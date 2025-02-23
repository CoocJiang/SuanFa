package mt;

import java.util.*;

public class No15 {
    public static void main(String[] args) {
        threeSum(new int[]{0,0,0,0}).forEach(System.out::println);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]>0){
                break;
            }else {
                if (set1.contains(nums[i])){
                    continue;
                }
                set1.add(nums[i]);
                int j = i+1,k=nums.length-1;
                HashSet<Integer> set = new HashSet<>();
                while (j<k){
                    sum = nums[i]+nums[j]+nums[k];
                    if (sum<0){
                        j++;
                    } else if (sum>0) {
                        k--;
                    }else {
                        if (!set.contains(nums[j])){
                            ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        }
                        set.add(nums[j]);
                        j++;
                    }
                }
            }
        }
        return ans;
    }

    private static void process(int[] nums, int index, int sum, List<Integer> list) {

    }
}
