package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No2111 {
    public static void main(String[] args) {
        System.out.println(kIncreasing(new int[]{2,2,2,2,2,1,1,4,4,3,3,3,3,3}, 1));
    }
    static int [] arr1 = new int[100000];
    public static int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int length ;
        for (int i = 0;i<k;i++){
            length = (n-i+k-1)/k;
            int s = lengthOfLIS(arr,i,k);
            count=count+length-s;
        }
        return count;
    }
    static int l,r,mid;
    public static int lengthOfLIS(int[] nums,int start,int k) {
        int n = nums.length;
        int length = 0;

        arr1[0] = nums[start];
        for (int i = start+k;i<n;i=i+k){
            if (nums[i]>=arr1[length]){
                //如果能更新子序列长度数组
                arr1[++length] = nums[i];
            }else{
                //
                 l = 0;
                 r = length;
                int ans = 0;
                while(l<=r){
                     mid = l+((r-l)>>1);
                    if (nums[i]>=arr1[mid]){
                        l = mid+1;
                    }else{
                        ans = mid;
                        r = mid-1;
                    }
                }
                arr1[ans] = nums[i];
            }
        }
        return length+1;
    }
}
