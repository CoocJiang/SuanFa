package A_leetcode.面试150;

public class No153 {
    public static void main(String[] args) {
        int [] nums = {3,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin1(int[] nums) {
        if (nums ==null){
            return 0;
        }
        int mid  = (nums.length-1)/2;
        int left = 0;
        int right = nums.length-1;
        int min = nums[mid];
        while (left<=right){
           if (nums[mid]<=nums[right]){
               min = Math.min(nums[mid],min);
               right=mid-1;
               mid = (left+right)/2;
           }else {
               left = mid+1;
               mid=(left+right)/2;
           }
        }
        return min;
    }

    public static int findMin(int[] nums) {
        int l  = 0;
        int n = nums.length;
        int r = n-1;
        int min = Integer.MAX_VALUE;
        while(l<=r){
            int m = l+(r+l)>>>1;
            if(nums[m]>nums[r]){
                l = m+1;
            }else{
                min = Math.min(min,nums[m]);
                r = m-1;
            }
        }
        return min;
    }
}
