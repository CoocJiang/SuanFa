package A_leetcode.面试150;

public class 统计一个园中点的数目 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int [] nums = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            for(int j = 0;j<points.length;j++){
                double squareRoot=Math.sqrt((points[j][0] - queries[i][0]) * (points[j][0] - queries[i][0]) +(points[j][1] - queries[i][1]) * (points[j][1] - queries[i][1]));
                if(squareRoot<=queries[i][2]){
                    nums[i]++;
                }
            }
        }
        return nums;
    }
}
