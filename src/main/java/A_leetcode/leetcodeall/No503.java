package A_leetcode.leetcodeall;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class No503 {

    public static void main(String[] args) {
        for (int i : nextGreaterElements(new int[]{5,4,3,2,1})) {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int [] ans = new int[nums.length];
        for (int i  = 0;i< nums.length;i++){
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                ans[stack.pop()] = nums[i];

            }
            stack.push(i);
        }
        int size = stack.size();
        for (int i = 0;i<nums.length;i++){
            while (!stack.isEmpty()&&nums[i]>nums[stack.peek()]){
                ans[stack.pop()] = nums[i];
            }
        }
        while (!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        return ans;
    }
}
