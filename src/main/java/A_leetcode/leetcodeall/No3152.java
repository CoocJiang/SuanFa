package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No3152 {
    public static void main(String[] args) {
        for (boolean b : isArraySpecial(new int[]{3,7,8}, new int[][]{  {0, 2} })) {
            System.out.println(b);
        }
    }
    static boolean [] answser;
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = queries.length;
        answser = new boolean [n];
        int [] arr = new int[nums.length];
        int sum = 0;
        for (int i = 1;i<arr.length;i++){
            arr[i] = nums[i]%2==nums[i-1]%2 ? 1:0;
            sum+=arr[i];
            arr[i] = sum;
        }
        int start,end;
        for (int i = 0;i<queries.length;i++){
            start = queries[i][0];
            end = queries[i][1];
            if (arr[end] - arr[start]>0){
                answser[i] = false;
            }else {
                answser[i] = true;
            }
        }
        return answser;
    }
    public static boolean isSpecial(int[] nums,int start,int end) {
        if(end == start){
            return true;
        }
        int pre ;
        int prepre;
        for(int i = start;i<end;i++){
            if (nums[i]!=0){
                prepre = nums[i+1]%2;
                pre = nums[i]%2;
                if(pre==prepre){
                    return false;
                }
            }
        }
        return true;
    }
}
