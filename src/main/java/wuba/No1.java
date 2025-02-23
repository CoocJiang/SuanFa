package wuba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1 {

    public static void main(String[] args) {
        for (int[] ints : findIntersection(new int[][]{{1, 2}, {3, 4}}, new int[][]{{2, 3}})) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

    public static int[][] findIntersection (int[][] firstList, int[][] secondList) {
        // write code here
        int length1 = firstList.length;
        int length2 = secondList.length;

        List<int []> ans = new ArrayList<>();

        Arrays.sort(firstList,(o1,o2)-> o1[0]-o2[0]);
        Arrays.sort(secondList,(o1,o2)-> o1[0]-o2[0]);

        int l = 0;
        int r = 0;
        int firstB = 0;
        int firstE = 0;
        int secondB = 0;
        int secondE = 0;
        while (l<length1&&r<length2){
            firstB = firstList[l][0];
            firstE = firstList[l][1];
            secondB = secondList[r][0];
            secondE = secondList[r][1];
            if (firstB>secondE){
                r++;
            }else if (firstE<secondB){
                l++;
            }else{
                if (secondE>firstE){
                    ans.add(new int[]{Math.max(firstB,secondB),firstE});
                    l++;
                }else {
                    ans.add(new int[]{Math.max(firstB,secondB),secondE});
                    r++;
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
