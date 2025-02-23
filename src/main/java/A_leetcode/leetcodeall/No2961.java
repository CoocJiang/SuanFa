package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No2961 {
    public static void main(String[] args) {
        int[][] variables = {
                {2, 3, 3, 10},
                {3, 3, 3, 1},
                {6, 1, 1, 4}
        };

        for (Integer goodIndex : getGoodIndices(variables, 2)) {
            System.out.println(goodIndex);
        }
    }
    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        int [] cur;
        for (int i = 0;i<variables.length;i++){
            cur = variables[i];
            int first = pow(cur[0],cur[1],10);
            int result = pow(first,cur[2],cur[3]);
            if (result==target) ans.add(i);
        }
        return ans;
    }
    private static int pow(int a,int b,int mod){
        if (b==1){
            return a%mod;
        }
        int half = 0;
        if (b%2==0){
            half = pow(a,b/2,mod);
            return half*half%mod;
        }else{
            half = pow(a,b/2,mod);
            return half*half*a%mod;
        }
    }
}
