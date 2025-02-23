package Everyday;

public class No2717 {

    public static void main(String[] args) {
        System.out.println(semiOrderedPermutation(new int[]{2, 1, 4, 3}));
    }
    public static int semiOrderedPermutation(int[] nums) {
        int a = find(1,nums);
        int b = find(nums.length,nums);
        if (a<b) return a+nums.length-1-b;
        return  a+nums.length-1-b-1;
    }
    public static int find(int tar,int [] nums){
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==tar){
                return i;
            }
        }
        return 0;
    }
}
