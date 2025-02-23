package 单调栈;
import java.io.*;
public class Nowcode单调栈 {

    static int [] stack  = new int[1000001];

    static int right = 0;

    static int [][] ans = new int[1000001][2];

    static int [] arr = new int[1000001];

    static int n = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] str = bf.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        String [] s = bf.readLine().split(" ");
        right = 0;
        int current = 0;
        for(int i = 0;i<n;i++){
            arr [i] = Integer.parseInt(s[i]);
            //先查看栈里是否有东西，并且是否小于栈顶
            while(right > 0&& arr[i] <= arr[stack[right-1]]){
                //弹出栈顶
                current = stack[--right];
                //栈顶元素压着的作为比current小的最近的数
                ans[current][0] = right > 0 ? stack[right-1]:-1;
                //弹出栈顶的作为右边比current小的数
                ans[current][1] = i;
            }
            stack[right++] = i;
        }
        //遍历结束之后
        //清算阶段
        while(right>0){
            int cur = stack[--right];
            ans [cur][0] = right > 0 ? stack[right-1]:-1;
            ans [cur][1] = -1;
        }
        //修正阶段
        for(int i = n-2;i>=0;i--){
            if(ans[i][1]!=-1&&arr[ans[i][1]]==arr[i]){
                ans[i][1] = ans[ans[i][1]][1];
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            out.println(ans[i][0] + " " + ans[i][1]);
        }
        out.flush();
        out.close();
    }
}
