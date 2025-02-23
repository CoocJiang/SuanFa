package A_leetcode.笔试;

public class test22 {

    public static void main(String[] args) {
        int  [][]arr = {{1,2,3},{3,4,5},{4,3,6}};
        System.out.println(process1(arr,0,0));
    }

    public static int process1(int[][] arr,int r,int c ){
        int n = arr.length;
        int m = arr[0].length;
        int [][] dp = new int[arr.length][arr[0].length];
        dp[n-1][m-1] = arr[n-1][m-1];
        for (int index=n-2;index>=0;index--){
            dp[index][m-1] = arr[index][m-1]+dp[index+1][m-1];
        }
        for (int index=m-2;index>=0;index--){
            dp[n-1][index] = arr[n-1][index]+dp[n-1][index+1];
        }
        for (int i=n-2;i>=0;i--){
            for (int j=m-2;j>=0;j--){
                dp[i][j] = arr[i][j] + Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

    public static int process(int[][] arr,int r,int c ){
        //向下或者向右
        int ans = arr[r][c]+arr[arr.length-1-c][arr.length-r-1];
        int p1=0;
        int p2=0;
        if (r+c<arr.length){
            if (r+1<arr.length){
                p1=  process(arr,r+1,c);
            }
            if (c+1<arr[0].length){
                p2 =  process(arr,r,c+1);
            }
        }
        ans   +=  Math.max(p1,p2);
        return ans;
    }
}
