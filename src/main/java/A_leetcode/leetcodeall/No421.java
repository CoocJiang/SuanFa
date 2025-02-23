package A_leetcode.leetcodeall;

import java.util.HashMap;
import java.util.HashSet;

public class No421 {

    public static void main(String[] args) {
        System.out.println(findMaximumXOR2(new int[]{10, 10, 10, 10, 10, 10}));
    }
    static int [][] tree ;
    // 前缀树目前使用了多少空间
    public static int cnt;

    // 数字只需要从哪一位开始考虑
    public static int high;

    public static void build(int[] nums) {
        cnt = 1;
        // 找个最大值
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // 计算数组最大值的二进制状态，有多少个前缀的0
        // 可以忽略这些前置的0，从left位开始考虑
        high = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            insert(num);
        }
    }
    public static int findMaximumXOR(int[] nums) {
        tree = new int[20000][2];
        build(nums);
        int max = 0;
        for (int i=0;i<nums.length;i++){
            max = Math.max(max,getMax(nums[i]));
        }
        return max;
    }

    private static int getMax(int num) {
        int ans =  0;
        int cur = 1;
        for (int i =high;i>=0;i--){
            int a = num&(1<<i);
            if (a==1<<i){
                if (tree[cur][0]!=0){
                    cur = tree[cur][0];
                    ans+=1<<i;
                }else {
                    cur = tree[cur][1];
                }
            }else {
                //a==0;
                if (tree[cur][1]!=0){
                    cur=tree[cur][1];
                    ans+=1<<i;
                }else {
                    cur = tree[cur][0];
                }
            }
        }
        return ans;
    }

    private static void insert(int num) {
        int cur = 1;
        for (int i = high;i>=0;i--){
            if ((num&(1<<i))==1<<i){
                if (tree[cur][1]==0) {
                    tree[cur][1] = ++cnt;
                }
                cur = tree[cur][1];
            }else {
                if (tree[cur][0]==0) {
                    tree[cur][0] = ++cnt;
                }
                cur = tree[cur][0];
            }
        }
    }

    public static int findMaximumXOR2(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // 计算数组最大值的二进制状态，有多少个前缀的0
        // 可以忽略这些前置的0，从left位开始考虑
        high = 31 - Integer.numberOfLeadingZeros(max);
        int ans = 0;
        HashSet<Integer>map1 = new HashSet<>();
        for (int i= high;i>=0;i--){
            map1.clear();
            int better = ans|1<<i;
            for (int num:nums){
                num = (num>>i)<<i;
                map1.add(num);
                if (map1.contains(better^num)){
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }
}
