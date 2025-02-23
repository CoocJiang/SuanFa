package A_leetcode.面试150;

public class No11 {
    //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    public static void main(String[] args) {
        int [] num = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(num));
    }
    public static int maxArea(int[] height) {
        int r = height.length-1;
        int l = 0;
        int maxcontain=0;
        maxcontain = Math.min(height[l],height[r])*r;
        while(r!=l){
            maxcontain = Math.max(Math.min(height[l],height[r])*(r-l),maxcontain);
            if(height[r]>height[l]){
                l++;
            }else{
                r--;
            }
        }
        return maxcontain;
    }
}
