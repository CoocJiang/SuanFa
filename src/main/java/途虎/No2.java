package 途虎;

import java.util.*;

public class No2 {

    public static void main(String[] args) {
        System.out.println(maxPoints(6, new int[]{8, 3, 7, 5, 6, 2}, new int[][]{{1, 0}, {2, 1}, {3, 1}, {4, 2},{1,0}}, 3));
    }
    public static int maxPoints (int n, int[] points, int[][] dependencies, int k) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i<dependencies.length;i++){
            set.add(dependencies[i][0]);
            if (map.containsKey(dependencies[i][1])){
                map.get(dependencies[i][1]).add(dependencies[i][0]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(dependencies[i][0]);
                map.put(dependencies[i][1],list);
            }
        }
        List<Integer> noneed = new ArrayList<>();
        for (int i = 0;i<n;i++){
            if (!set.contains(i)){
                noneed.add(i);
            }
        }
        int count = 0;
        int ans = 0;
        int [] cur;
        int index = 0;
        ans = process(0,noneed,map);
        return ans;
    }

    private static int process(int index,List<Integer> noneed, HashMap<Integer, List<Integer>> map) {
        return 0;
    }
}
