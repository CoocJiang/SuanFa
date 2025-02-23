package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No2860 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,0,3,3,6,7,2,7);
        System.out.println(countWays(list));
    }

    public static int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int count = 0;
        int size = nums.size();
        for (int i = 0;i<size-1;i++){
            //如果选
            if (i+1>nums.get(i)&&((i+1)<nums.get(i+1))){
                count++;
            }
        }
        if (nums.get(0)>0){
            count++;
        }
        if (size>nums.get(size-1)){
            count++;
        }
        return count;
    }
}
