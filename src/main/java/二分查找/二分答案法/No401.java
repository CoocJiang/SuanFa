package 二分查找.二分答案法;

public class No401 {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,4,4}, 3));
    }
        public static int splitArray(int[] nums, int k) {
            int max = 0;
            int min = 0;
            for(int i = 0;i<nums.length;i++){
                max+=nums[i];
                min = Math.max(nums[i],min);
            }
            int l = min;//取min是为了缩小范围，其次防止一个数都装不下
            int r = max;
            int ans = max;
            while(l<=r){
                int mid = l + ((r-l)>>>1);
                if(f(mid,nums)<=k){
                    ans = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            return ans;
        }

        public static int f(int mid,int [] nums){
            int ans = 0;
            for(int l = 0,r = 0;r<nums.length;){
                int sum = 0;
                sum = nums[r++];
                while (r<nums.length&&(sum+nums[r])<=mid){
                    sum +=nums[r++];
                }
                l = r;
                ans++;
            }
            return ans;
        }



}
