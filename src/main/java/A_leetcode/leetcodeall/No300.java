package A_leetcode.leetcodeall;

import javax.xml.bind.annotation.XmlMimeType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class No300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
    }




    static int l,r,mid;
    static int [] arr = new int[2500];
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int length = 0;
        Arrays.fill(arr,2500);
        arr[0] = nums[0];
        for (int i = 1;i<n;i++){
            if (nums[i]>arr[length]){
                //如果能更新子序列长度数组
                arr[++length] = nums[i];
            }else{
                //
                l = 0;
                r = length;
                int ans = 0;
                while(l<=r){
                    mid = l+((r-l)>>1);
                    if (nums[i]>arr[mid]){
                        l = mid+1;
                    }else{
                        ans = mid;
                        r = mid-1;
                    }
                }
//                if(nums[i]<arr[ans]){
                    arr[ans] = nums[i];
//                }
            }
        }
        return length+1;
    }


    public static int lengthOfLIS1(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1;i< nums.length;i++){
            int max = 1;
            for (int j = 0;j<i;j++){
                if (nums[i]>nums[j]){
                    max = Math.max(dp[j]+1,max);
                }
            }
            dp[i] = max;
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }

}
