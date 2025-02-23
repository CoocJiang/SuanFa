package 途虎;

import A_leetcode.面试150.删除有序数组中的重复项;

import java.util.ArrayList;
import java.util.List;

public class No3 {


    public int roadPlan (int cityNumber, int roadNumber, int[][] roadArray) {
        // write code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0;i<cityNumber;i++){
           graph.add(new ArrayList<>());
        }
        int [] road;
        for (int i = 0;i<roadArray.length;i++){
            road = roadArray[i];
            int start = road[0];
            int end = road[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        return 0;
    }


    public static void union (Unifind a,Unifind b){
        if (a.size>b.size){
            a.size += b.size;
            b.father = a.father;
            b.size = a.size;
        }else {
            b.size+=a.size;
            a.father = b.father;
            a.size = b.size;
        }
    }
    static class Unifind{

        int father;

        int city;

        int size;

        public Unifind( int num) {
            this.father = num;
            city = num;
            size = 1;
        }

        public int getfather(int city){
            return father;
        }
    }
}
