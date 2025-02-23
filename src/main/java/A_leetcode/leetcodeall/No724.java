package A_leetcode.leetcodeall;

public class No724 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i = 0 ;i < nums.length; i++ ){
            sum+=nums[i];
            nums[i] = sum;
        }
        int index = 1;
        if(nums[nums.length-1]-nums[0]==0){
            return 0;
        }
        while(index<nums.length-1){
            int zuo = nums[index-1];
            int you = nums[nums.length-1]-nums[index];
            if(zuo==you){
                return index;
            }
            index++;
        }
        return -1;
    }
}
