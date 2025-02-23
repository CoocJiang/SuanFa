package A_leetcode.No138;

import java.util.*;

public class NoQ4 {
    public static void main(String[] args) {
        System.out.println(minDamage(8, new int[]{40}, new int[]{59}));
    }
    public static long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        double [] arr = new double[n];
        TreeMap<Double, List<Integer>> treeMap = new TreeMap<>((k1,k2)-> k2-k1>0 ? 1:-1);
        int damages = 0;
        int [] huihes = new int[n];
        long all = 0;
        for (int i = 0;i<n;i++){
            int s = health[i]+power-1;
            huihes[i] = s/power;
            arr[i] = damage[i]*1.00/(s/power);
            damages+=damage[i];
            if (treeMap.containsKey(arr[i])){
                treeMap.get(arr[i]).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                treeMap.put(arr[i],list);
            }
        }
        for (Map.Entry<Double,List<Integer>> entry:treeMap.entrySet()){
            for (Integer integer : entry.getValue()) {
                all+= (long) huihes[integer] *damages;
                damages -= damage[integer];
            }
        }
        return  all;
    }
}
