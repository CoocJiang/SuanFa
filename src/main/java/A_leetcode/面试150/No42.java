package A_leetcode.面试150;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class No42 {

    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        new TreeMap<>();
    }
    static int [] stack = new int[100000];

    static int r ;

    static int cur;

    static int sum;

    static int [] ans = new int[100000];
    public static int trap3(int[] height) {
        sum=0;
        r=0;
        ans[0] = -1;
        for (int i=0;i<height.length;i++){
            while (r>0){
                cur = stack[r-1];
                sum += ((i-cur)-1)*(Math.min(height[i],height[cur])-ans[i]);
                ans[i] = height[cur];
                if (ans[i]>=height[i]){
                    break;
                }else {
                    r--;
                }
            }
            stack[r++] = i;
        }

        while (r>1){
            cur = stack[--r];
            int a= ((cur-stack[r-1])-1)*(Math.min(height[cur],height[stack[r-1]])-ans[cur]);
            if (a>=0){
                sum += a;
            }
        }
    return sum;
    }


    public static int trap1(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        sum=0;
        ans[0] = -1;
        for (int i=0;i<height.length;i++){
            while (stack.size()>0){
                cur = stack.peek();
                sum += ((i-cur)-1)*(Math.min(height[i],height[cur])-ans[i]);
                ans[i] = height[cur];
                if (ans[i]>=height[i]){
                    break;
                }else {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        while (stack.size()>1){
            cur = stack.pop();
            int a= ((cur-stack.peek())-1)*(Math.min(height[cur],height[stack.peek()])-ans[cur]);
            if (a>=0){
                sum += a;
            }
        }
        return sum;
    }

    //以上是单调栈
    //以下使用双指针

    public static int trap2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int result = 0;
        int h = 0;
        boolean flag = false;
        while (left<right){
            if (height[right]<=h){
                right--;
                if (left==right){
                    break;
                }
                if (height[right]>=h){
                    result-=h;
                }else {
                    result-=height[right];
                }
                continue;
            }
            if (height[left]<=h){
                left++;
                if (left==right){
                    break;
                }
                if (result > 0) {
                    if (height[left]>=h){
                        result-=h;
                    }else {
                        result-=height[left];
                    }
                }
                continue;
            }
            result += (right-left-1)*(Math.min(height[right],height[left])-h);
            h = Math.min(height[right],height[left]);
        }
        return result;
    }

    //双指针简易版
    public static int trap(int[] height){
        int l = 0;
        int r = height.length-1;
        int rmax = height[r];
        int lmax = height[l];
        r--;
        l++;
        int sum = 0;
        while (r>=l){
            if (rmax>lmax){
                // l移动
                sum += Math.max(0,lmax-height[l]);
                lmax = Math.max(lmax,height[l++]);
            }else{
                // r 移动
                sum += Math.max(0,rmax-height[r]);
                rmax = Math.max(lmax,height[r--]);
            }
        }
        return  sum;
    }

}

