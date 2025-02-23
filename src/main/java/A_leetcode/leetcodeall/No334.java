package A_leetcode.leetcodeall;

public class No334 {

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{5, 1, 6}));
    }
    //题解1
    public static boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n<3){
            return false;
        }
        int [] leftmin = new int[n];
        int [] rightmax = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<n;i++){
            leftmin[i] = Math.min(min,nums[i]);
            min  =  leftmin[i];

            rightmax[n-i-1] = Math.max(max,nums[n-i-1]);
            max = rightmax[n-i-1];
        }
        for (int i = 1;i<n-1;i++){
            if (leftmin[i-1]<nums[i]&&nums[i]<rightmax[i+1]){
                return true;
            }
        }
        return false;
    }


    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n<3){
            return false;
        }
        int first = nums[0];
        int sed = Integer.MAX_VALUE;
        for (int i = 1;i<n;i++){
            if (nums[i]>sed){
                return true;
            } else if (nums[i]<=first){
                first = nums[i];
            }else if (nums[i]<sed){
                sed = nums[i];
            }
        }
        return false;
    }
}
