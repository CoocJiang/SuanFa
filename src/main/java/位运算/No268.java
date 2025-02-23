package 位运算;

public class No268 {

    //给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
    public int missingNumber(int[] nums) {
        int ero = 0;
        for(int i=0;i<nums.length;i++){
            ero=ero^i;
        }
        int ero1 = 0;
        for(int i:nums){
            ero1= ero1 ^ i;
        }
        return ero^ero1;
    }
}
