package A_leetcode.leetcodeall;

public class No239 {

    public static void main(String[] args) {
        for (int i : maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)) {
            System.out.print(i);
        }
    }
    static int MAXN = 100000;
    static int [] deque = new int [MAXN] ;
    static int l ;
    static int r ;
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int [n+1-k];
        int start = 0;
        l = 0;
        r = 0;
        //初始化单调队列
        for(int i = 0;i<k-1;i++){
            while(l<r&&nums[deque[r-1]]<nums[i]){
                r--;
            }
            deque[r++] = i;
        }
        for(int i = k-1;i<n;i++){
            while(l<r&&nums[deque[r-1]]<nums[i]){
                r--;
            }
            deque[r++] = i;
            if (i-k+1==deque[l]){
                ans[start++] = nums[deque[l++]];
            }else{
                ans[start++] = nums[deque[l]];
            }
        }
        return ans;
    }
}
