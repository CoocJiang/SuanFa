package A_leetcode.leetcodeall;

public class No3128 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {1, 0, 0},
                {1, 0, 0}
        };

        System.out.println(numberOfRightTriangles(matrix));
    }
    static long ans;
    static int n;
    static  int []rowsum;
    static int []colsum;
    public static long numberOfRightTriangles(int[][] grid) {
        n = grid.length;
        int m = grid[0].length;
        rowsum = new int[n];
        colsum = new int[m];
        ans = 0;
        for (int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                rowsum[i]+=grid[i][j];
            }
        }
//        for (int j = 0;j<m;j++){
//            for(int i = 0;i<n;i++){
//               colsum[j]+=grid[i][j];
//            }
//        }
//        for (int i = 0;i<n;i++){
//            for(int j = 0;j<m;j++){
//                if (grid[i][j]==1){
//                    ans+= (long) (rowsum[i] - 1) *(colsum[j]-1);
//                }
//            }
//        }
        for (int j = 0;j<m;j++){
            int rsum = 0;
            int csum = 0;
            for (int i = 0;i<n;i++){
                if (grid[i][j]==1){
                    //计算上面传过来的列上的总的1
                    ans+= (long) (rowsum[i] - 1)  * csum;
                    //计算上面传过来的行大于1的行
                    ans+= (long) rsum;
                    rsum = rsum+rowsum[i]-1;
                    csum = csum+1;
                }
            }
        }
        return ans;
    }

//    private static void processs(int[][] grid, int i, int j,int rsum,int csum) {
//        //当前来到 i j位置，如果i不是 n-1
//        if (grid[i][j]==1){
//            if (i==n-1){
//                //计算上面传过来的列上的总的1
//                ans+= (long) (rowsum[i] - 1)  * csum;
//                //计算上面传过来的行大于1的行
//                ans+= (long) rsum;
//                return;
//            }
//            //计算上面传过来的列上的总的1
//            ans+= (long) (rowsum[i] - 1)  * csum;
//            //计算上面传过来的行大于1的行
//            ans+= (long) rsum;
//            processs(grid,i+1,j,rsum+rowsum[i]-1,csum+1);
//            return;
//        }else{
//            if (i==n-1){
//                return;
//            }
//           processs(grid,i+1,j,rsum,csum);
//
//            return;
//        }
//    }


}
