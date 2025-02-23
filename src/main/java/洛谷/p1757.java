package 洛谷;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class p1757 {

    static int c,v,zu;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        //代表每一组  map [i]
        int [][]arr = new int[n+1][3];
        int zunums = 1; //记录组的数量
        int zunumber = 0;// 记录组的编号
        for (int i = 1;i<=n;i++){
            s = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]); //cost
            arr[i][1]  = Integer.parseInt(s[1]);//val
            arr[i][2]  = Integer.parseInt(s[2]);//分组
            if(zunumber!=0&&arr[i][2]!=zunumber){
                zunums++;
            }
            zunumber = arr[i][2];
        }
        //按组号进行排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        long [][]dp = new long[zunums+1][m+1];
        for (int i = 1,start = 1,end = 2;start<=n;i++){
            while(end<=n&&arr[start][2]==arr[end][2]){
                end++;
            }
            //至此 start - end(不包扩end）就变成一个组的数据了
            for (int j = 0;j<=m;j++){
                //这一组都不要
                dp[i][j] =  dp[i-1][j];
                for (int k = start;k<end;k++){
                    if (j-arr[k][0]>=0){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-arr[k][0]]+arr[k][1]);
                    }
                }
            }
            start = end++;
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(dp[zunums][m]);
        out.close();
    }
}
