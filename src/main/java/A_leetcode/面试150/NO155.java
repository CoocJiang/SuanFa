package A_leetcode.面试150;

import java.util.*;

public class NO155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

    }
   static class MinStack {

        int [] stacks = new int[3*100000];
        int [] minstack = new int[3*100000];
        int r;

        int mr;

        public MinStack() {
            this.r = 0;
            this.mr = 0;
        }

        public void push(int val) {
            stacks[r++] = val;
           if(mr==0||val<=minstack[mr-1]){
               minstack[mr++] = val;
           }
        }

        public void pop() {
            if (r>0){
                r--;
                if (mr-1>=0&&stacks[r]==minstack[mr-1]){
                    mr--;
                }
            }
        }

        public int top() {
            return stacks[r-1];
        }

        public int getMin() {
            return mr-1>=0 ? minstack[mr-1]:0;
        }
    }
}
