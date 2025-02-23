package A_leetcode.笔试;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class taomitest4 {

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses (String s) {
        // write code here
        char[] chars = s.toCharArray();
        Deque<Integer> stack  = new LinkedList<>();
        int max = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='('){
                stack.push(i);
            }else {
                //不是左括号就是右括号
                if (!stack.isEmpty()){
                    if (chars[stack.peek()]=='('){
                        stack.pop();
                        if (stack.isEmpty()){
                            max = Math.max(max,i+1);
                            continue;
                        }else {
                            max = Math.max(max,i-stack.peek());
                            continue;
                        }
                    }
                }
                stack.push(i);
            }
        }
        return max;
    }
}
