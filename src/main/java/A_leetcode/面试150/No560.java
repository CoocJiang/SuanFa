package A_leetcode.面试150;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

public class No560 {

    public static void main(String[] args) {
        System.out.println(subarraySum3(new int[]{1}, 0));
    }

    //哈希表加前缀和
    public static int subarraySum3(int[] nums, int aim) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - aim)) {
                ans+=map.get(sum-aim);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            }else{
                map.put(sum,map.get(sum)+1);
            }
        }
        return ans;
    }

    public static int subarraySum1(int[] nums, int k) {
        int [] pre = new int[nums.length];
        int sum  = 0;
        for (int i = 0;i<nums.length;i++)
        {
            sum+=nums[i];
            pre[i]=sum;
        }
        int count =  0;
        for (int i=nums.length-1;i>=0;i--){
            if (pre[i]==k){
                count++;
            }
            for (int j = i-1;j>=0;j--){
                int cha = pre[i]-pre[j];
                if (cha==k){
                    count++;
                }
            }
        }
        return count;
    }


    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i = 0;i< nums.length;i++){
            sum+=nums[i];
            int need = sum-k;
            if (map.containsKey(need)){
                count=count+map.get(need);
            }
            if (map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else {
                map.put(sum,1);
            }
        }
        return count;
    }

}

