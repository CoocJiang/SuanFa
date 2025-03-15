package A_leetcode.面试150;

public class No45 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    public static int jump(int[] nums) {
        if (nums.length==0) return 1;
        int times = 0;
        for (int i = 0; i < nums.length-1; ) {
            int step = nums[i];
            if (step == 0)  break;
            int nextStep = i+1;
            times++;
            if (step+i>=nums.length-1) return times;
            for (int j = 1;j<=step;j++){
                if(nums[i+j]+i+j>nextStep+nums[nextStep]){
                    nextStep = i+j;
                }
            }
            i = nextStep;
        }
        return times;
    }
}
