package 洛谷;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;

public class P2698 {
    static int MAXN = 100001;
    static int [][] arr;

    static int [] maxdeque = new int[MAXN];

    static int [] mindeque = new int[MAXN];

    static  int limit;
    static int  maxh,maxt,minh,mint;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        limit  = Integer.parseInt(split[1]);
        arr = new int[n][2];
        for (int i = 0;i<n;i++){
            split = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        maxh = 0;
        maxt = 0;
        minh = 0;
        mint = 0;
        int min = Integer.MAX_VALUE;
        //此时arr是以坐标从小到达排好序的
        for (int l = 0,r = 0;l<n&&r<n;l++){
            while (r<n&&!ok()){
                //此时时间差小于limit不满足条件，必须扩充范围
                while (maxh<maxt&&arr[r][1]>=arr[maxdeque[maxt-1]][1]){
                    maxt--;
                }
                maxdeque[maxt++] = r;
                while (minh<mint&&arr[r][1]<=arr[mindeque[mint-1]][1]){
                    mint--;
                }
                mindeque[mint++] = r;
                r++;
                if (ok()){
                    min  = Math.min(min,arr[r-1][0]-arr[l][0]);
                    r++;
                    break;
                }
            }
            if (ok()){
                min  = Math.min(min,arr[r-1][0]-arr[l][0]);
                r++;
                break;
            }
            if (maxdeque[maxh]==l){
                maxh++;
            }
            if (mindeque[minh]==l){
                minh++;
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(min==Integer.MAX_VALUE? -1:min);
        out.close();
    }


    public static boolean ok(){
        int max = maxh < maxt ? arr[maxt][1]:0;
        int min = minh < mint ? arr[mint][1]:0;
        return max-min >= limit;
    }
}
