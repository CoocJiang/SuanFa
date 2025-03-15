package A_leetcode.leetcodeall;

public class No55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,1,0,0}));
    }
    public static boolean canJump(int[] nums) {
        int maxStep = nums[0];
        for (int i = 0; i < nums.length; ) {
            int step = nums[i];
            if (step == 0)  break;
            int nextStep = i+1;
            for (int j = 1;j<=step;j++){
                if(nums[i+j]+i+j>nextStep+nums[nextStep]){
                    nextStep = i+j;
                }
            }
            i = nextStep;
        }
        return true;
    }
}
