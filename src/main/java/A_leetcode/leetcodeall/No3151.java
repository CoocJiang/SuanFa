package A_leetcode.leetcodeall;

public class No3151 {
    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[]{2, 1, 4}));
    }
    public static boolean isArraySpecial(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int pre = nums[1]%2;
        int prepre = nums[0]%2;
        if (pre==prepre){
            return false;
        }
        for(int i = 2;i<nums.length;i++){
            prepre = pre;
            pre = nums[i]%2;
            if(pre==prepre){
                return false;
            }
        }
        return true;
    }
}
