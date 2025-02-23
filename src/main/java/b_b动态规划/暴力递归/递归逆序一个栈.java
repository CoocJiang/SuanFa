package b_b动态规划.暴力递归;

import java.util.Stack;

public class 递归逆序一个栈 {



    //使用递归逆序一个栈

    //取出栈最底下的元素，并且保证栈的结构不改变
    public static int bottom(Stack<Integer> stack){
            int nums = stack.pop();
            if (stack.isEmpty()){
                return nums;
            }else {
                int ans = bottom(stack);
                stack.push(nums);
                return ans;
            }
    }


    //把栈进行逆序
    public static Stack<Integer> nixu(Stack<Integer> stack){
        if (!stack.isEmpty()){
            int nums = bottom(stack);
            nixu(stack);
            stack.push(nums);
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        Stack<Integer> nixu = nixu(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }




}
