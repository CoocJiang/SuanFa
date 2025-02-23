package A_leetcode.leetcodeall;

public class No238 {
    public static void main(String[] args) {

        for (int i : productExceptSelf(new int[]{-1,1,0,-3,3})) {
            System.out.println(i);
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] arr1 = new int[nums.length];
        int [] arr2 = new int[nums.length];
        arr1[0] = nums[0];
        arr2[n-1] = nums[n-1];
        for(int i = 1;i<nums.length-1;i++){
            arr1[i] = arr1[i-1]*nums[i];
            arr2[n-1-i] = arr2[n-i]*nums[n-1-i];
        }
        nums [0] = arr2[1];
        nums[n-1] = arr1[n-2];
        for(int i = 1;i<nums.length-1;i++){
            nums[i] = arr1[i-1]*arr2[i+1];
        }
        return nums;
    }
}

