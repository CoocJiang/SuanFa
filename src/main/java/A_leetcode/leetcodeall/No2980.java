package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No2980 {


    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int num:nums){
            if (num%2==0){
                if (++count>1){
                    return true;
                }
            }
        }
        return false;
    }
}
