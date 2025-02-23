package A_leetcode.leetcodeall;

public class NO283 {
    public static void main(String[] args) {
        moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
    }
//        public static void moveZeroes(int[] nums) {
//            int left  = 0;
//            int right = nums.length-1;
//            while(left<=right){
//                if (nums[left]==0){
//                    for (int i=0;i+left<right;i++){
//                        nums[i+left] = nums[i+left+1];
//                    }
//                    nums[right] = 0;
//                    right--;
//                }else {
//                    left++;
//                }
//            }
//        }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        for (;left<nums.length;left++){
            if (nums[left]!=0){
                nums[right++] =nums[left];
            }
        }
        for (int i=0;i<(nums.length-right);i++){
            nums[nums.length-i-1] = 0;
        }
    }


}
