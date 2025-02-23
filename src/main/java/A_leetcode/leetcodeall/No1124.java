package A_leetcode.leetcodeall;

import java.util.HashMap;

public class No1124 {

    public static void main(String[] args) {
        System.out.println(longestWPI(new int[]{12,8,7,7,9,10,8,7,9,7,8,11}));
    }
    public static int longestWPI(int[] hours) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for(int i=0;i<hours.length;i++ ){
            if(hours[i]>8){
                sum++;
            }else{
                sum--;
            }
            if(sum>0){
                ans = i+1;
            }else{
                if(map.containsKey(sum-1)){
                    ans = Math.max(ans,i-map.get(sum-1));
                }else{
                    if (!map.containsKey(sum)){
                        map.put(sum,i);
                    }
                }
            }
        }
        return ans;
    }
}
