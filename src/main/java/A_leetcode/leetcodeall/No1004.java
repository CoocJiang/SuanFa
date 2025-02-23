package A_leetcode.leetcodeall;

public class No1004 {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1}, 9));
    }

    public static int longestOnes1(int[] nums, int k) {
        int max = 0;
        for (int i=0;i<nums.length-max;i++){
            int count = k;
            int cur = i;
            int sum = 0;
            while (cur<nums.length&&(nums[cur]==1||count>0)){
                if ((nums[cur]&1)==0){
                    count--;
                }
                cur++;
                sum++;
            }
            max = Math.max(sum,max);
        }
        return  max;
    }
    public static int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int count = k;
        while (right<nums.length){
            if (nums[right]==1){
                right++;
                max = Math.max(max,right-left);
            }else {
                if (count>0){
                    right++;
                    count--;
                    max = Math.max(max,right-left);
                }else {
                    if (nums[left]==0){
                        left++;
                        right++;
                    }else {
                        while (nums[left]==1){
                            left++;
                        }
                    }
                }
            }
        }
        return max;
    }
}
