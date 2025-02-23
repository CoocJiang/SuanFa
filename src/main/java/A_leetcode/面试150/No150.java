package A_leetcode.面试150;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class No150 {

    public static void main(String[] args) {
        String [] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    static   String [] stacks = new String[10000];

    static   int right ;
    static int left ;

    public static int evalRPN(String[] tokens) {
        right= 0;
        left=0;
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+")||tokens[i].equals("*")||
                    tokens[i].equals("/")||tokens[i].equals("-")){
                String b = stacks[--right];
                String a = stacks[--right];
                stacks[right++] = calculate(a,b,tokens[i]);
            }else {
                stacks[right++] = tokens[i];
            }
        }
        return Integer.parseInt(stacks[--right]);
    }

    public static String calculate(String a,String b,String c){
        if (c.equals("+")){
            return String.valueOf(Integer.parseInt(a)+Integer.parseInt(b));
        } else if (c.equals("-")){
            return String.valueOf(Integer.parseInt(a)-Integer.parseInt(b));
        } else if (c.equals("*")){
            return String.valueOf(Integer.parseInt(a)*Integer.parseInt(b));
        }else {
            return String.valueOf(Integer.parseInt(a)/Integer.parseInt(b));
        }
    }
}
