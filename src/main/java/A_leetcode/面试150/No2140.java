package A_leetcode.面试150;

public class No2140 {
    public static void main(String[] args) {
        int [][] qe = {{43,5}};
        System.out.println(mostPoints2(qe));
    }
    public static long mostPoints(int[][] questions) {
        long [] dp = new long[questions.length+1];
        return process(0,questions,dp);
    }
    public  static long process(int index,int[][] questions,long dp[]){
        //basecase
        if (index>=questions.length){
            return 0;
        }
        if (dp[index]!=0){
            return dp[index];
        }
        //到了index处的问题，只有两种选择，解决or跳过
        //解决
        long ans1 = questions[index][0]+process(index+1+questions[index][1],questions,dp);
        //跳过
        long ans2 = process(index+1,questions,dp);
        dp[index]  = Math.max(ans2,ans1);
        return dp[index];
    }

    //优化
    public static long mostPoints2(int[][] questions) {
        long [] dp = new long[questions.length];
        dp[questions.length-1] = questions[questions.length-1][0];
        long max = dp[questions.length-1];
        for (int i= questions.length-2;i>=0;i--){
            long p1  = dp[i+1];
            long p2 = questions[i][0] + (i+1+questions[i][1] < dp.length? dp[i+1+questions[i][1]]:0);
            dp[i] =  Math.max(p1,p2);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
