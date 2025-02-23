package qynaer;
import java.io.*;
import java.util.Arrays;
import java.util.Map;


public class Main {
    static int [][] cs = new int[2001][10];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().split(" ")[0]);
        String split = bf.readLine();
        char[] chars = split.toCharArray();
        int [] arr = new int[10];
        int [] dp = new int[chars.length];
//        for (int i = 0;i<chars.length;i++){
//            arr[chars[i]-'0']++;
//            cs[i] = Arrays.copyOf(arr,10);
//            for (int j = 0;j<i;j++){
//                dp[i] = Math.max(dp[i],dp[j]+process1(j,i));
//            }
//        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(process(0,arr,chars));
        out.flush();
        out.close();
    }

    private static int process1(int j, int i) {
        for (int index = 0;index<10;index++){
            if ((cs[i][index] - cs[j][index])%2!=0){
                return 0;
            }
        }
        return 1;
    }

    public static int process (int index,int [] arr,char [] chars){
        if (index==chars.length){
            return 0;
        }else {
            //先判断当前位置是否能 组成 一个假周期串
            int num = ++arr[chars[index]-'0'];
            boolean flag = true;
            boolean flag2 = false;
            if (num>=2){
                for (int i = 0;i<10;i++){
                    if (i == chars[index]-'0'){
                        flag2 = true;
                        continue;
                    }
                    if (arr[i]!=0&&arr[i]!=num){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag&&flag2){
                //组得成分为两种
                //不组
                int p1 = process(index+1,arr,chars);

                //组成假字符串
                Arrays.fill(arr,0);
                int p2 =1 + process(index+1,arr,chars);

                return Math.max(p1,p2);
            }else {
                //组不成
                return process(index+1,arr,chars);
            }
        }
    }
}
