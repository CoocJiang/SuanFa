package A_leetcode.leetcodeall;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LCR036 {
    public static void main(String[] args) {

        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
    public static int evalRPN(String[] tokens) {
        LinkedList<String> stack  = new LinkedList<>();
        for (int i = 0;i<tokens.length;i++){
            if (tokens[i].equals("+")){
                int a =  Integer.parseInt(stack.poll());
                int b =  Integer.parseInt(stack.poll());
                stack.push(String.valueOf(a+b));
            } else if (tokens[i].equals("*")) {
                int a =  Integer.parseInt(stack.poll());
                int b =  Integer.parseInt(stack.poll());
                stack.push(String.valueOf(a*b));
            }else if (tokens[i].equals("/")) {
                int a =  Integer.parseInt(stack.poll());
                int b =  Integer.parseInt(stack.poll());
                stack.push(String.valueOf(b/a));
            }else if (tokens[i].equals("-")) {
                int a =  Integer.parseInt(stack.poll());
                int b =  Integer.parseInt(stack.poll());
                stack.push(String.valueOf(b-a));
            }else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.poll());
    }
}
