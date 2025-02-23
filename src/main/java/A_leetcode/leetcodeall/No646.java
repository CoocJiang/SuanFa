package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Comparator;

public class No646 {
    public static void main(String[] args) {
        int[][] array = {
                {7, 9},
                {4, 5},
                {7, 9},
                {-7, -1},
                {0, 10},
                {3, 10},
                {3, 6},
                {2, 3}
        };
        System.out.println(findLongestChain(array));
    }
    static int [] arr  = new int[1000];
    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        //按第一个元素从小到大排序
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        arr[0] = pairs[0][1];
        int lenngth = 1;
        int r;
        int l;
        int mid;
        int [] cur;
        int ans = 0;
        for (int i = 1;i<n;i++){
            cur = pairs[i];
            if (cur[0]>arr[lenngth-1]){
                arr[lenngth++] = cur[1];
                continue;
            }
            r = lenngth-1;
            l = 0;
            while (l<=r){
                mid = l+((r-l)>>1);
                if (cur[0]>arr[mid]){
                    l = mid+1;
                }else{
                    ans = mid;
                    r = mid-1;
                }
            }
            if (cur[1]<arr[ans]){
                arr[ans] = cur[1];
            }
        }
        return lenngth;
    }
}
