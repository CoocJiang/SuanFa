package A_leetcode.面试150;

public class No74 {




    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix ==null){
            return false;
        }
        for (int [] nums:matrix){
            int mid  = (nums.length-1)/2;
            int left = 0;
            int right = nums.length-1;
            while (left<=right){
                if (target <nums[mid]){
                    right = mid-1;
                    mid=(right+left)/2;
                }else if (target >nums[mid]){
                    left= mid+1;
                    mid=(left+right)/2;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
