package shope;

import b_b动态规划.暴力递归.咖啡机问题;

import java.util.Arrays;

public class No3 {

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }

    static int [][][] dp = new int[2][1001][1001];
    public static int wiggleMaxLength(int[] nums) {
        // write code here
        if (nums.length<3){
            return nums.length;
        }else {
            for (int i = 0;i<2;i++){
                for (int j = 0;j<nums.length;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }
            int max = 2;
            for (int i = 1;i<nums.length;i++){
                int cur = nums[i]-nums[i-1];
                if (cur>0){
                    max = Math.max(max,2+process(i+1,nums,nums[i],1));
                }else if (cur<0){
                    max = Math.max(max,2+process(i+1,nums,nums[i],0));
                }
            }
            return max;
        }
    }

    public static int wiggleMaxLength1(int[] nums) {
        // write code here
        if (nums.length<3){
            return nums.length;
        }else {
            int max = 2;
            for (int i = 1;i<nums.length;i++){
                int num = nums[i]-nums[i-1];
                if (num>0){
                    Node cur = new Node(i,1);
                    for (int j = i+1;j<nums.length;j++){
                        if (cur.flag==0){
                            if (nums[j]>nums[cur.index]){
                                cur.count++;
                                cur.index = j;
                                cur.flag = 1;
                                max = Math.max(max, cur.count);
                            } else{
                                cur.index = j;
                            }
                        }else {
                            if (nums[j]<nums[cur.index]){
                                cur.count++;
                                cur.index = j;
                                cur.flag = 0;
                                max = Math.max(max, cur.count);
                            } else{
                                cur.index = j;
                            }
                        }
                    }
                }else if (num<0){
                    Node cur = new Node(i,0);
                    for (int j = i+1;j<nums.length;j++){
                        if (cur.flag==0){
                            if (nums[j]>nums[cur.index]){
                                cur.count++;
                                cur.index = j;
                                cur.flag = 1;
                                max = Math.max(max, cur.count);
                            } else{
                                cur.index = j;
                            }
                        }else {
                            if (nums[j]<nums[cur.index]){
                                cur.count++;
                                cur.index = j;
                                cur.flag = 0;
                                max = Math.max(max, cur.count);
                            } else{
                                cur.index = j;
                            }
                        }
                    }
                }
            }
            return max;
        }
    }

    static class Node{
        int index;
        int flag;
        int count = 2;

        public Node(int index, int flag) {
            this.index = index;
            this.flag = flag;
        }
    }


    private static int process(int index, int[] nums, int num, int b) {
        if (index<nums.length&&dp[b][index][num]!=-1){
            return dp[b][index][num];
        }
        if (index==nums.length){
            return 0;
        }else {
            if (b==1){
                //找比num小的;
                if (nums[index]<num){
                    int p1 = 1+process(index+1,nums,nums[index],0);
                    int p2 = process(index+1,nums,nums[index],1);
                    dp[b][index][num] = Math.max(p1,p2);
                }else {
                    dp[b][index][num] =process(index+1,nums,nums[index],1);
                }
            }else {
                //找比num大的
                if (nums[index]<num){
                    dp[b][index][num] = process(index+1,nums,nums[index],0);
                }else {
                    int p1 = 1+process(index+1,nums,nums[index],1);
                    int p2 = process(index+1,nums,nums[index],0);
                    dp[b][index][num] = Math.max(p1,p2);
                }
            }
            return dp[b][index][num];
        }
    }
}
