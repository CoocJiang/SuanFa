package b_贪心算法实战.b_b动态规划进阶.class21;

public class  Z_Bovdie {
    public static void main(String[] args) {

    }


    //当前位置 row col
    //可以走k步
    //范围大小为N行k列

    public static double livePosibility1(int row, int col, int k, int N, int M){
        if (k==0){
            return 1;
        }
        return process3(row,col,k,N,M)/Math.pow(4,k);
    }

    private static long process3(int row, int col, int rest, int n, int m) {
        //basecase
        if (row < 0 || row == n || col < 0 || col == m) {
            return 0;
        }
        // 还在棋盘中！
        if (rest == 0) {
            return 1;
        }
        //有四种情况，上，下，左，右
        return   process3(row+1,col,rest-1,n,m)+
                process3(row,col+1,rest-1,n,m)+
                process3(row-1,col,rest-1,n,m)+
                process3(row,col-1,rest-1,n,m);
    }



    
}
