package A_leetcode.leetcodeall;

public class No1499 {


    public static void main(String[] args) {
        int[][] coordinates = {
                {-19, -12},
                {-13, -18},
                {-12, 18},
                {-11, -8},
                {-8, 2},
                {-7, 12},
                {-5, 16},
                {-3, 9},
                {1, -7},
                {5, -4},
                {6, -20},
                {10, 4},
                {16, 4},
                {19, -9},
                {20, 19}
        };
        System.out.println(findMaxValueOfEquation(coordinates, 6));
    }
    static int MAXN = 100001;

    static int [][] deque = new int[MAXN][2];

    static int h,t;
    public static int findMaxValueOfEquation(int[][] points, int k) {
        t = 0;
        h = 0;
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int x = points[i][0];
            int y = points[i][1];
            //当队列里有东西并且此时的point满足 |xi - xj| <= k就尝试更新最大值
            while(t>h&&(k+deque[h][0])<x){
                h++;
            }
            if(t>h){
                ans = Math.max(ans,points[i][1]+deque[h][1]+(points[i][0]-deque[h][0]));
            }
            while(t>h&&(y-x)>=(deque[t-1][1]-deque[t-1][0])){
                t--;
            }
            deque[t][0] = points[i][0];
            deque[t++][1] = points[i][1];
        }
        return ans;
    }
}
