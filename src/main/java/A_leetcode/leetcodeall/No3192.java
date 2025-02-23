package A_leetcode.leetcodeall;

public class No3192 {


    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(1, 3, 1));
    }

    static int mod = 1000000007;
    public static int numberOfStableArrays(int zero, int one, int limit) {
        // 当前位置选择 0 减去 后续 0 会超标 的情况 得到当前置放 0 的所有答案
        // 当前位置选择 1 减去 后续 1 会超标 的情况 得到当前置放 1 的所有答案
        long p1 =(process(zero-1,one,0,limit));
        long p2 = process(zero-limit-1,one,0,limit);
        long p3 = (p1-p2+mod)%mod;
        long p4 = process(zero,one-1,1,limit);
        long p5 = process(zero,one-limit-1,1,limit);
        long p6 = (p4-p5+mod)%mod;
        long p7 = (p3+p6+mod)%mod;
        return(int) p7;
    }
    // process的含义： zero代表剩余0的数目，one 代表剩余1的数目，num代表 当前位置选择的数是1还是0 limit代表限制
    private static long process(int zero,int one, int num,int limit) {
        //如果超出给定范围 返回0
        if (zero<0||one<0){
            return 0;
        }else if (zero==0&&one==0){
            //如果正好为 0 说明找到一种方法
            return 1;
        }
        // 当前位置选择 0 减去 后续 0 会超标 的情况 得到当前置放 0 的所有答案
        // 当前位置选择 1 减去 后续 1 会超标 的情况 得到当前置放 1 的所有答案
        long p1 =(process(zero-1,one,0,limit));
        long p2 = process(zero-limit-1,one,0,limit);
        long p3 = (p1-p2+mod)%mod;
        long p4 = process(zero,one-1,1,limit);
        long p5 = process(zero,one-limit-1,1,limit);
        long p6 = (p4-p5+mod)%mod;
        long p7 = (p3+p6+mod)%mod;
        return (int) p7;
    }
    private static int dfs(int zero, int one, int k, int limit) {
        if (zero==0&&one<=limit){
            return k == 1  ? 1 : 0;
        }else if (one==0&&zero<=limit){
            return k == 1  ? 1 : 0;
        }else if (zero<0||one<0){
            return 0;
        }else {
            if (k==0){
                return dfs(zero-1,one,0,limit)+dfs(zero-1,one,1,limit)-dfs(zero-limit-1,one,0,limit);
            }else {
                return dfs(zero,one-1,0,limit)+dfs(zero,one-1,1,limit)-dfs(zero,one-limit-1,1,limit);
            }
        }
    }
}
