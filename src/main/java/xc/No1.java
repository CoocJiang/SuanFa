package xc;

import java.io.*;

public class No1 {

    static int [] move = new int[]{1,0,-1,0,1};
    static  int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int times = Integer.parseInt(s[0]);
        int k = 0;
        for (int i = 0;i<times;i++){
            s = bf.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            k = Integer.parseInt(s[2]);
            long ans = 0;
            if (k<n){
                int c = 1;
                while (k>0){
                    ans+=c*m;
                    k--;
                    c++;
                }
            }else if(k<(n+m-1)) {
                int c = 1;
                int j = 1;
                while (c<n){
                    ans+=c*m;
                    k--;
                    c++;
                }
                c--;
                while (k>0){
                    ans+=c*m+j;
                    j++;
                    k--;
                }
            }else {
                int c = 1;
                int j = 1;
                while (c<n){
                    ans+=c*m;
                    k--;
                    c++;
                }
                c--;
                while (j<m){
                    ans+=c*m+j;
                    j++;
                    k--;
                }
                j--;
                int max = c*m+j;
                boolean flag = true;
                while (k>0){
                    if (flag){
                        ans+=max-1;
                    }else {
                        ans+=max;
                    }
                    flag = !flag;
                    k--;
                }
            }
            out.println(ans);
        }
        out.close();
    }

    private static long process(int k, int r, int c) {
        if (k==0) return 0;
        int [] next = new int[4];
        long max = 0;
        long value = c+ (long) r *m;
        for (int i = 1;i< move.length;i++){
            int nr = r+move[i-1];
            int nc = c+move[i];
            if (nr>=0&&nr<n&&nc>=0&&nc<m){
                max = Math.max(max,value+process(k-1,nr,nc));
            }
        }
        return max;
    }
}
