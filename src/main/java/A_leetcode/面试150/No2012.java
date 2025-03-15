package A_leetcode.面试150;

public class No2012 {
    public int sumOfBeauties(int[] nums) {
        int length = nums.length;
        int[][] arr = new int[length][2];
        int max = nums[0];
        int min = nums[length - 1];
        for (int i = 1; i < length; i++) {
            arr[i][0] = max;
            max = Math.max(max, nums[i]);
            arr[length - i - 1][1] = min;
            min = Math.min(min, nums[length - i - 1]);
        }
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > arr[i][0] && nums[i] < arr[i][1]) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }
        return res;
    }
}
