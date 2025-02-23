package A_leetcode.面试150;

public class 除自身以外数的乘积 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] answer = new int[nums.length];
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            copy[i] = 1;
            int m = 1;
            for (int j = 0; j < nums.length; j++) {
                m = m * copy[j];
            }
            answer[i] = m;
            System.out.println(answer[i]);
            System.arraycopy(nums, 0, copy, 0, nums.length);
        }
    }
}
