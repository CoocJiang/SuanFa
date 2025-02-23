package b_b动态规划.暴力递归;

public class 机器人走路 {
    public static void main(String[] args) {
        System.out.println(ways2(4,2,4,4));
    }

    public static int ways1(int N,int M,int K,int P){
        //建立表格，将数值存入表格
        int [][] record = new int[N+1][K+1];
        for (int i=1;i<N+1;i++){
            for (int j=0;j<K+1;j++){
                record[i][j] = -1;
            }
        }
        int ans = 0;
        ans= proces1(N,M,K,P,ans,record);
        return ans;
    }
    //总共有N个位置，1-N，机器人在M位置，还剩K步，目的地是P
    public static int proces1(int N,int M,int K,int P,int ans,int[][] record){
        //先判断表格里有无，有的话无需递归直接取出需要的数值
        if (record[M][K]!=-1){
            return record[M][K];
        }
        //如果此时剩下的步数为0，直接返回
        if (K==0){
            record[M][0] = M == P ? ans+1:ans;
            return  record[M][0];
        }
        //如果在1，只能往右走
        else if(M==1){
            return record[1][K] = proces1(N,M+1,K-1,P,ans,record);
        }
        //在N只能往左走
        else if (M==N){
            return record[N][K] = proces1(N,M-1,K-1,P,ans,record);
        }
//        在中间可以往左也可以往右
        else {
            return record[M][K] = proces1(N,M-1,K-1,P,ans,record)+proces1(N,M+1,K-1,P,ans,record);
        }
    }

    public static int ways2(int N,int M,int K,int P){
        //建立表格，将数值存入表格,代表在M位置还有K步，有record[M][K]种方法可以回到P位置
        int [][] record = new int[N+1][K+1];
        record[P][0] = 1;
        for (int i=1;i<K+1;i++){
            record[1][i] = record[2][i-1];
            for (int j=2;j<N;j++){
                record[j][i]=record[j-1][i-1]+record[j+1][i-1];
            }
            record[N][i] = record[N-1][i-1];
        }
        return record[M][K];
    }
}
