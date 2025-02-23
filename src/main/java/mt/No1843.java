package mt;

import java.util.*;

public class No1843 {
    public static void main(String[] args) {
        int[][] array = {
                {5, 2},
                {7, 2},
                {9, 4},
                {6, 3},
                {5, 10},
                {1, 1}
        };
        for (int i : getOrder(array)) {
            System.out.println(i);
        }
    }
    public static int[] getOrder(int[][] tasks) {
        int [] task;
        List<int []> heap= new ArrayList<>();
        for (int i = 0;i<tasks.length;i++){
            task = tasks[i];
            heap.add(new int[]{task[0],task[1],i});
        }
        heap.sort((o1, o2) -> o1[0] - o2[0] == 0 ?
                o1[1] - o2[1] == 0 ? o1[2] - o2[2] : o1[1] - o2[1] : o1[0] - o2[0]);
        int [] ans = new int[tasks.length];
        int [] first = heap.get(0);
        int time = first[1]+first[0];
        int index = 1;
        int hindex = 1;
        ans[0] = first[2];
        PriorityQueue<int []> heap2 = new PriorityQueue<>(((o1, o2) ->
                o1[1]-o2[1]==0 ? o1[2]-o2[2]:o1[1]-o2[1]));
        int [] cur;
        while (hindex<heap.size()|| !heap2.isEmpty()){
            while (hindex<heap.size()&&heap.get(hindex)[0]<=time){
                heap2.add(heap.get(hindex++));
            }
            if (heap2.isEmpty()){
                cur = heap.get(hindex++);
                ans[index++] = cur[2];
                time=Math.max(time+cur[1],cur[1]+cur[0]);
            }else {
                cur = heap2.poll();
                ans[index++] = cur[2];
                time+=cur[1];
            }
        }
        return ans;
    }
}
