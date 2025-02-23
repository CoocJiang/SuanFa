package wyyz;
import java.io.*;
import java.util.Arrays;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int length = Integer.parseInt(s[1]);
        s = bf.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        int [][] graph = new int[length][2];
        int B,E;
        for (int i = 0;i<length;i++){
            s = bf.readLine().split(" ");
            B = Integer.parseInt(s[0]);
            E = Integer.parseInt(s[1]);
            graph[i][0] = B;
            graph[i][1] = E;
        }
        Arrays.sort(graph,(a,b)-> a[0]-b[0]);
        int [] be = new int[]{start,start};
        int times = 0;
        int [] max = new int[2];
        if (start<end){
            boolean flag = true;
            for (int i = 0;i<graph.length;){
                boolean f = true;
                while (i<graph.length&&be[1]>=graph[i][0]&&be[1]<=graph[i][1]){
                    f = false;
                    if (graph[i][1]>max[1]){
                        max[0] = i;
                        max[1] = graph[i][1];
                    }
                    i++;
                }
                times++;
                be[0] = graph[max[0]][0];
                be[1] = max[1];
                if (end<=max[1]){
                    out.println(times);
                    flag =false;
                    break;
                }
                if (f){
                    i++;
                }
            }
            if (flag) out.println(-1);
        }else {
            out.println(0);
        }
        out.close();
    }
}
