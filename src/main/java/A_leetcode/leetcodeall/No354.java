package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Comparator;

public class No354 {
    public static void main(String[] args) {
        int[][] array = {
                {16, 1},
                {6, 9},
                {16, 12},
                {8, 7},
                {18, 16},
                {8, 10},
                {13, 19},
                {16, 7},
                {7, 20},
                {13, 6},
                {9, 11},
                {10, 13},
                {15, 19},
                {8, 11}
        };
        System.out.println(maxEnvelopes(array));
    }
    static int r,l,mid;
    public static int maxEnvelopes(int[][] envelopes) {
        //先按高度进行排序,因为会出先高度一样的情况，高度一样就按宽度从大到小排序，因为小的后面会会更新大的值，
        // 如果大的放后面，小的就会被更新，就可以转换为最长递增子序列问题了
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[1] - o2[1]==0 ? o2[0] - o1[0]:o1[1] - o2[1];
            }
        });
        int [] ends = new int[envelopes.length];
        int length = 1;
        ends[0] = envelopes[0][0];
        for (int i = 1;i<envelopes.length;i++){
            if (envelopes[i][0]>ends[length-1]){
                ends[length++] = envelopes[i][0];
                continue;
            }else {
                int ans = 0;
                l = 0;
                r = length-1;
                while (l<=r){
                    mid = l+((r-l)>>1);
                    if (envelopes[i][0]>ends[mid]){
                        l = mid+1;
                    }else{
                        ans = mid;
                        r = mid-1;
                    }
                }
                ends[ans] = envelopes[i][0];
            }
        }
        return length;
    }
}
