package A_leetcode.leetcodeall;

public class No689 {
        public static void main(String[] args) {
            for (int i : maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)) {
                System.out.println(i);
            }
        }
        static int [] ans = new int[3];
        public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length;
            //定义2个数组
            // arr1[i] 代表以i结尾 最大的长度为k的最大字数组的起始下标
            // arr2[i] 代表以i开头 最大长度为k的最大字数组起始下标
            // sum1[i] 代表以i结尾 最大的长度为k的最大字数组的累加和
            // sum2[i] 代表以i开头 最大长度为k的最大字数组的累加和
            // 创建arr1
            int arr1[] = new int[n];
            int arr2[] = new int[n];
            int sum1[] = new int[n];
            int sum2[] = new int[n];
            int sum = 0;
            for(int i = 0;i<k;i++){
                sum+=nums[i];
            }
            int newsum = sum;
            sum1[k-1] = sum;
            for(int i = k;i<n;i++){
                sum=sum+nums[i]-nums[i-k];
                if(sum>newsum){
                    newsum = sum;
                    arr1[i] = i-k+1;
                }else{
                    arr1[i] = arr1[i-1];
                }
                sum1[i] = newsum;
            }

            //创建arr2[]
            sum = 0;
            for(int i = n-1;i>=n-k;i--){
                sum+=nums[i];
            }
            arr2[n-k] = n-k;
            sum2[n-k] = sum;
            newsum = sum;
            for(int i = n-k-1;i>=0;i--){
                sum=sum+nums[i]-nums[i+k];
                if(sum>=newsum){
                    newsum = sum;
                    arr2 [i] = i;
                }else{
                    arr2[i] = arr2[i+1];
                }
                sum2[i] = newsum;
            }
            sum = 0;
            int max = 0;
            for(int i = 0;i<k;i++){
                sum+=nums[k+i-1];
            }
            for(int i = k;i<n-k;i++){
                sum = sum + nums[i+k-1] - nums[i-1];
                newsum = sum+sum1[i-1]+sum2[i+k];
                if(newsum>max){
                    max = newsum;
                    ans[0] = arr1[i-1];
                    ans[1] = i;
                    ans[2] = arr2[i+k];
                }
            }
            return ans;
        }
}
