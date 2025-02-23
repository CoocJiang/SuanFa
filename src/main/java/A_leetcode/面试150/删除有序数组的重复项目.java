package A_leetcode.面试150;

public class 删除有序数组的重复项目 {
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        int last = 0;
        while(right<nums.length){
            if(nums[left]==nums[right]){
                right++;
            }else if(right-left>=1){
                for(int i=1;i<(right-left);i++){
                    nums[left+i] = nums[right];
                }
                left++;
                last=right;
                right++;
            }
        }
        for (int j =0;j<right;j++){
            System.out.print(nums[j]+" ");
        }
        System.out.println();
        return  last+1;
    }

    public static void main(String[] args) {
        int [] arr= {1,2};
        System.out.println(removeDuplicates(arr));
    }
}
