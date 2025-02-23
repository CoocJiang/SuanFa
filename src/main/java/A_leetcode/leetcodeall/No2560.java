package A_leetcode.leetcodeall;

public class No2560 {
    public static void main(String[] args) {
        System.out.println(minCapability(new int[]{2, 3, 5, 9}, 2));
    }

    public static int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }
        int mid;
        int ans = max;
        while(min<=max){
            mid = (min+max)/2;
            if(process(nums,mid)>=k){
                max = mid-1;
                ans = mid;
            }else{
                min = mid+1;
            }
        }
        return ans;
    }

    //定义一个函数，给一个数能力值，返回这个能力值能偷的最多数目的房屋
    public static int process(int[] nums,int available){
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(available>=nums[i]){
                sum++;
                i++;
            }
        }
        return sum;
    }
}
