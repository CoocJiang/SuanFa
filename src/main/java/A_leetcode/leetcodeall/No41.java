package A_leetcode.leetcodeall;

public class No41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1}));
    }
    public static int firstMissingPositive(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            if(nums[l] == l+1){
                l++;
            }else{
                if((l+1)<nums[l]&&nums[l]<=(r+1)&&nums[nums[l]-1]!=nums[l]){
                    swap(nums,l,nums[l]-1);
                }else{
                    swap(nums,l,r);
                    r--;
                }
            }
        }
        return l+1;
    }

    public static void swap(int [] arr,int l,int r){
        int temp = arr[l];
        arr[l]  =  arr[r];
        arr[r]  = temp ;
    }
}
