package A_leetcode.面试150;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 轮转数组 {
    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5,6,7};
        int copy [] = new int[nums.length];
        int k = 3;
        for (int i = 0;i<k;i++){
            System.arraycopy(nums,nums.length-1-i,nums,k-1-i,1);
        }
        System.arraycopy(nums,0,copy,k,nums.length-k);
        System.arraycopy(copy,0,nums,0,nums.length);
        for(int i : nums){
            System.out.println(i);
        }
    }
}
