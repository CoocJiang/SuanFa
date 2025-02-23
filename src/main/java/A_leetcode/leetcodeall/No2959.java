package A_leetcode.leetcodeall;

public class No2959 {


    public static void floyd(int n) {
        // 0(N^3)的过程
        // 枚举每个跳板
        //注意,跳板要最先枚举!跳板要最先枚举!跳板要最先枚举!
        int[][] distance = new int[n][n];

        for (int bridge = 0; bridge < n; bridge++) { //
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // i -> ..... bridge .... -> j
                    //distance[i][j]能不能缩短
                    // distance[i][j] = min ( distance[i][j], distance[i][bridge] + distance[bridge][j])
                    if (distance[i][bridge] != Integer.MAX_VALUE
                            && distance[bridge][j] != Integer.MAX_VALUE
                            && distance[i][j] > distance[i][bridge] + distance[bridge][j]) {
                        distance[i][j] = distance[i][bridge] + distance[bridge][j];
                    }
                }
            }
        }
    }
}
