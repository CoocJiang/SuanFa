package A_leetcode.面试150;

import java.awt.font.MultipleMaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }


    public static List<Integer> result;
    public static int lengthOfLIS(int[] nums) {
        return process(0,nums,0);
    }

    public static int process(int index,int [] arr,int num){
        //basecase
        if (index==arr.length){
            return 0;
        }
        //来到index位置，要或者不要
        int p1 = 0;
        int p2 = 0;
        if (index==0||index-1>=0&&arr[index]>num){
            //yao
            p1  = process(index+1,arr,arr[index])+1;
        }
        p2 = process(index+1,arr,num);
        return Math.max(p1,p2);
    }
}
