package A_leetcode.leetcodeall;

public class No1438 {


    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{10,1,2,4,7,2}, 5));
    }

    static int MAXN = 100000;
    static int l1 ;
    static int r1 ;
    static int l2 ;
    static int r2 ;

    public static int longestSubarray(int[] nums, int limit) {
        int [] deque1 = new int [MAXN] ;
        int [] deque2 = new int [MAXN] ;
        int n  =  nums.length;
        l1 = 0;
        r1 = 0;
        l2 = 0;
        r2 = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        for(;l<n&&r<n;l++){
            while(r<n&&(nums[deque1[l1]]-nums[deque2[l2]])<=limit){
                //当单调队列的最大值和最小值差小于Limit 就可以扩
                //对单调最大值队列进行判断
                while(l1<r1&&nums[r]>nums[deque1[r1-1]]){
                    r1--;
                }
                deque1[r1++] = r;
                //对单调最小值队列进行判断
                while(l2<r2&&nums[r]<nums[deque2[r2-1]]){
                    r2--;
                }
                deque2[r2++] = r;
                if ((nums[deque1[l1]]-nums[deque2[l2]])<=limit){
                    max = Math.max(max,r-l+1);
                    r++;
                }else {
                    r++;
                    break;
                }
            }
            if (deque1[l1] == l){
                l1++;
            }
            if (deque2[l2]==l){
                l2++;
            }
        }
        return max;
    }
}
