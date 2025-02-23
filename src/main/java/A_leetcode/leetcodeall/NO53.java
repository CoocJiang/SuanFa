package A_leetcode.leetcodeall;

public class NO53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    static int [] pre;
    public  static int maxSubArray1(int[] nums) {
        pre = new int[nums.length];
        int sum = nums[0];
        int max= nums[0];
        for (int i=1;i<nums.length;i++){
            if (sum>=0){
                sum+=nums[i];
                max = Math.max(max,sum);
            }else {
                max = Math.max(max,nums[i]);
                sum=nums[i];
            }
        }
        return max;
    }



    //动态规划
    static int max;
    public static int maxSubArray(int[] nums) {
        max = nums[0];
        process(nums.length-1,nums);
        return max;
    }

    public static int process(int index,int [] nums){
        //basecase
        if (index==0){
            return nums[index];
        }
        int p1 = process(index-1,nums)+nums[index];
        int p2  = nums[index];
        int ans =  Math.max(p1,p2);
        max = Math.max(max,ans);
        return ans;
    }
}
