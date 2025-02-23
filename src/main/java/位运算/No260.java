package 位运算;

public class No260 {

    public static void main(String[] args) {
        for (int i : singleNumber(new int[]{1, 2, 1, 3, 2, 5})) {
            System.out.println(i);
        }
    }

    //给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
    //
    //你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
    public static int[] singleNumber(int[] nums) {
        int ero = 0;
        //假设a和b为只出现一次的数字
        for (int i:nums){
            ero = ero^i;
        }
        //得到的结果必然是 a^b

        //拿到最有ero最右边的1的位置
        int ero2 =ero&(~ero+1);
        //a和b中必有一个数在ero最右边为0或1
        //选取为0的全部异或出来必然得到a或b
        int ero3 = 0;
        for (int i:nums){
            if ((i&ero2)==0){
                ero3=i^ero3;
            }
        }
        return new int[]{ero^ero3,ero3};
    }
}
