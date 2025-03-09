package A_leetcode.leetcodeall;

public class No26 {
    public static void main(String[] args) {
        int [] arr = new int[]{1,1,2};
        removeDuplicates(arr);
    }
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length==1){
            return 1;
        }else{
            int slow = 0;
            int fast = 1;
            while(fast<length){
                if (nums[fast]!=nums[slow]){
                    nums[++slow] = nums[fast];
                }else {
                    fast++;
                }
            }
            return slow+1;
        }
    }
}
