package NowCoder;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class WY52 {



    public static int MAXM = 1 << 20;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int  n = Integer.parseInt(s[0]);
        long[] arr =new long [n];
        int content = Integer.parseInt(s[1]);
        s  = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(s[i]);
        }
        Arrays.sort(arr);
        int mid = n / 2;
        int l = 0;
        int r = 0;
        long[] left = new long[MAXM];
        long[] right = new long[MAXM];
//        l = f(0, mid, 0L, l,mid,left);
        r = process(arr,mid,0L,0,n,right);
        long ans = 0;
        Arrays.sort(left,0,l);
        Arrays.sort(right,0,r);
        for(int i = 0;i<l;i++){
            while(r>1&&((left[i]+right[r-1])>content)){
                r--;
            }
            ans+=r;
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(ans);
        out.flush();
        out.close();
    }
    public static int  process(long[] arr, int index, Long result, int l,int end,long [] nums) {
        if (index == end) {
            nums[l++] = result;
            return l;
        } else {
            l =  process(arr, index + 1, result + arr[index], l,end,nums);
            l = process(arr, index + 1, result, l,end,nums);
        }
        return l;
    }

    public static int f(int i, int e, long s, long w, long[] ans, int j,long []arr) {
        if (s > w) {
            return j;
        }
        // s <= w
        if (i == e) {
            ans[j++] = s;
        } else {
            // 不要arr[i]位置的数
            j = f(i + 1, e, s, w, ans, j,arr);
            // 要arr[i]位置的数
            j = f(i + 1, e, s + arr[i], w, ans, j,arr);
        }
        return j;
    }
}
