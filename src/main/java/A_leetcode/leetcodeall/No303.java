package A_leetcode.leetcodeall;

public class No303 {


    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    static class NumArray {

        public int [] nums;

        public int []count;

        public NumArray(int[] nums) {
            this.nums = nums;
            count = new int[nums.length];
            int sum = 0;
            for (int i = 0;i<nums.length;i++){
                sum += nums[i];
                count[i] = sum;
            }
        }

        public int sumRange(int left, int right) {

            return  count[right]-count[left]+nums[left];
        }
    }
}
