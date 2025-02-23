package A_leetcode.leetcodeall;

public class NO317_q1 {
    public static void main(String[] args) {
        for (int i : resultsArray(new int[]{1,2,3,4,3,2,5}, 3)) {
            System.out.println(i);
        }
    }
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int [] results = new int[n-k+1];
        int [] queue = new int[n];
        int h = 0;
        int t = 0;
        int cha = 0;
        for (int i = 0;i<k-1;i++){
            if (i>0){
                cha+=nums[i]-nums[i-1];
            }
            if (t>h&&nums[queue[t-1]]>=nums[i]){
                t--;
            }
            queue[t++] = i;
        }
        int l = 0;
        int r = k-1;
        for (;r<n;l++,r++){
            if (r>0) cha+=nums[r]-nums[r-1];
            while (h<t&&nums[queue[t-1]]>=nums[r]){
                t--;
            }
            queue[t++] = r;
            if (t-h ==k&&cha==k-1){
                results[r-k+1] = nums[queue[t-1]];
            }else {
                results[r-k+1] = -1;
            }
            if (queue[h]==l){
                h++;
            }
            if (l+1<n) cha-=nums[l+1]-nums[l];
        }
        return  results;
    }
}
