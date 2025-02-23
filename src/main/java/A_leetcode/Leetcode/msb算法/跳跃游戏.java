package A_leetcode.Leetcode.msb算法;

public class 跳跃游戏 {
    public static void main(String[] args) {
        int [] nums = {8,1,1,1,6,0,0};
        System.out.println(jump(nums));
    }
    public  static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
