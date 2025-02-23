package A_leetcode.leetcodeall;

public class No922 {

    public static void main(String[] args) {
        System.out.println(sortArrayByParityII(new int[]{4, 2, 5, 7}));
    }
    public static int[] sortArrayByParityII(int[] nums) {
        int l = 0;
        int r = 0;
        while(l<nums.length&&r<nums.length){
            l = find1(nums,l);
            r = find2(nums,r);
            if(l> nums.length||r>nums.length){
                break;
            }
            swap(nums,l,r);
        }
        return nums;
    }
    public static void swap(int [] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums [r] = temp;
    }


    public static int find2(int[] nums,int index){
        for(;index<nums.length;index++){
            if((index%2==1)&&(nums[index]%2==0)){
                return index;
            }else{
                continue;
            }
        }
        return index+1;
    }

    public static int find1(int[] nums,int index){
        for(;index<nums.length;index++){
            if((index%2==0)&&(nums[index]%2==1)){
                return index;
            }else{
                continue;
            }
        }
        return index+1;
    }
}
