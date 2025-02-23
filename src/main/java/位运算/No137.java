package 位运算;

public class No137 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
    }
    //给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    //你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
    public static int singleNumber(int[] nums) {
        int [] count = new int[32];
        for (int i:nums){
            for (int j=31;j>=0;j--){
                if ((i&(1<<j))!=0){
                    count[j]++;
                }
            }
        }
        int ans = 0;
        for (int i=0;i<count.length;i++){
            if (count[i]!=0&&(count[i]%3!=0)){
                ans+=1<<i;
            }
        }
        return ans;
    }
}
