package A_leetcode.leetcodeall;

import java.util.Deque;
import java.util.LinkedList;

public class No32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
    }

    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int [] dp = new int [chars.length];
        int length = 0;
        int max = 0;
        for (int index = 0;index<chars.length;index++){
            length = 0;
            if (chars[index]==')'){
                //说明此时是右括号‘）’
                if (index>=1){
                    if (chars[index-1]==')'){
                        int shang = dp[index-1];
                        if (index-1-shang>=0&&chars[index-1-shang]=='('){
                            length = dp[index-1]+2;
                            if (index-1-shang-1>=0&&chars[index-1-shang-1]==')'){
                                length += dp[index-1-shang-1];
                            }
                        }
                    }else {
                        length = index>2 ? dp[index-2]+2:2;
                    }
                }
            }
            dp[index] = length;
            max = Math.max(length,max);
        }
        return max;
    }





    public int longestValidParentheses1(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
