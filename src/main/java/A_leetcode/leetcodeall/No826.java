package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No826 {

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(
                new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82}));
    }
    public  static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int  [] []arr = new int[n][2];
        for (int i = 0;i<n;i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }

        Arrays.sort(arr,(o1,o2)-> o1[1] ==o2[1] ? o1[0]-o2[0]:o2[1]-o1[1]);

        Arrays.sort(worker);
        int ans = 0;
        int index = 0;
        for (int i = worker.length-1;i>=0;i--){
            while (index<n&&worker[i]<arr[index][0]){
                index++;
            }
            if (index<n){
                ans+=arr[index][1];
            }
        }
        return ans;
    }
}
