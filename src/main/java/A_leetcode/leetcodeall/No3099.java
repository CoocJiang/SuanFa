package A_leetcode.leetcodeall;

public class No3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        char [] num = String.valueOf(x).toCharArray();
        int ans = 0;
        int n = num.length;
        for (int i=0;i<n;i++){
            ans = ans + Integer.parseInt(String.valueOf(num[i]));
        }
        if(x%ans==0){
            return ans;
        }
        return -1;
    }
}
