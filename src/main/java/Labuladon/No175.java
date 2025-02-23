package Labuladon;

public class No175 {
    public static void main(String[] args) {
        int[][] dungeon = {
                {0, -3},
        };
        System.out.println(calculateMinimumHP(dungeon));
    }

//    static int need = 0;
    static int ans;
    static int [] move = new int[]{1,0,1};
    public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int [][] dp = new int[dungeon.length][dungeon[0].length];
        dp[n-1][m-1] = dungeon[n-1][m-1] >= 0 ? 1 :-dungeon[n-1][m-1] + 1;;
        for (int i = m-2;i>=0;i--){
            dp[n-1][i] = (dp[n-1][i+1] - dungeon[n-1][i]) <= 0 ? 1:dp[n-1][i+1] - dungeon[n-1][i];
        }
        for (int i = n-2;i>=0;i--){
            dp[i][m-1] = (dp[i+1][m-1] - dungeon[i][m-1]) <= 0 ? 1:dp[i+1][m-1] - dungeon[i][m-1];
        }
        for (int i = n-2;i>=0;i--){
            for (int j = m-2;j>=0;j--){
                int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = res <= 0 ? 1 : res;
            }
        }
        return dp[0][0];
    }

    private static void dfs(int x, int y, int hp,int need, int[][] dungeon) {
        if (x<0||x==dungeon.length||y<0||y==dungeon[0].length){
            return;
        }
        if (x==dungeon.length-1&&y==dungeon[0].length-1){
            int num = hp+dungeon[x][y];
            need = Math.min(need,num);
           ans = Math.max(ans,need);
        }else {
            int num = hp+dungeon[x][y];
            need = Math.min(need,num);
            for (int i = 1;i<move.length;i++){
                dfs(x+move[i-1],y+move[i],num,need,dungeon);
            }
        }
    }


}
