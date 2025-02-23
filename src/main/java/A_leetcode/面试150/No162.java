package A_leetcode.面试150;

public class No162 {

    public static void main(String[] args) {
        int [] nums = {1,2,1,2,1};
        findPeakElement(nums);
    }



    public static int findPeakElement(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        if (nums[left]>nums[left+1]){
            return left;
        }else if (nums[right]>nums[right-1]){
            return right;
        }else {
            while (left<=right){
                //如果中间是峰值位置
                if (nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]){
                    return mid;
                }
                //如果是升序
                else if (nums[mid-1]<nums[mid]){
                    left = mid;
                    mid = (left+right)/2;
                }
                else if (nums[mid-1]>nums[mid]){
                    right = mid;
                    mid = (left+right)/2;
                }
            }
        }
        return 0;
    }
}
