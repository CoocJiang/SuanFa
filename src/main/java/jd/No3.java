package jd;


import java.io.*;
public class No3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);

        int [][] position = new int[n][2];
        int x = 0;
        int y = 0;
        for (int i = 0;i<n;i++){
            s = bf.readLine().split(" ");
            position[i][0] = Integer.parseInt(s[0]);
            position[i][1] = Integer.parseInt(s[1]);
        }
        int nian = 0;
        int [][]distance = new int[n][n];
        int maxdis = 0;
        int mindis = Integer.MAX_VALUE;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                int dis = (int) Math.sqrt((position[j][0]-position[i][0])*(position[j][0]-position[i][0])+(position[j][1]-position[i][1])*(position[j][1]-position[i][1]));
                distance[i][j] = dis;
                distance[j][i] = dis;
            }
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                for (int k = 0;k<n;k++){
                    if (k==i||k==j){
                        continue;
                    }else {
                        distance[i][j] = Math.min(distance[i][j],Math.max(distance[i][k],distance[k][j]));
                        maxdis = Math.max(distance[i][j],maxdis);
                    }
                }
            }
        }
        int maxnian = ((maxdis+1)/2);
        int minnian =  ((mindis+1)/2);
        out.println(maxnian);
        out.close();
    }

    public static class Unifind{
        int [] f;
        int [] size;

        public Unifind(int[] f, int[] size) {
            this.f = f;
            this.size = size;
        }

        int getf(int i){
            if (f[i]!=i){
                f[i] = getf(i);
            }
            return f[i];
        }

        public void union(int a,int b){
            if (size[a]>=size[b]){
                f[b] = a;
                size[a]+=size[b];
            }else {
                f[a] = b;
                size[b]+=size[a];
            }
        }

        boolean isUnion(int a,int b){
            int af = getf(a);
            int bf = getf(b);
            return af == bf;
        }
    }
}
