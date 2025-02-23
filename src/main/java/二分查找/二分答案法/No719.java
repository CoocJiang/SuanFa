package 二分查找.二分答案法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No719 {

    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18));
    }
    public static int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n-1]-nums[0];
        int l = 0;
        int r = max;
        int ans = 0;
        while (l<=r){
            int mid = l + ((r-l)>>1);
            int result = f(mid,nums);
            if (result>=k){
                ans = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }

    private static int f(int mid, int[] nums) {
        int k = 0;
        for (int l = 0 ,r = 0;l<nums.length;l++){
            while (r+1<nums.length&&nums[r+1]-nums[l]<=mid) {
                r++;
            }
            k+=r-l;
        }
        return k;
    }
}
