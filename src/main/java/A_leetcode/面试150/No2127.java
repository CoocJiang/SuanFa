package A_leetcode.面试150;

import java.util.LinkedList;
import java.util.Queue;

public class No2127 {

    public static void main(String[] args) {
        int []a = {1,0,3,2,5,6,7,4,9,8,11,10,11,12,10};
        System.out.println(maximumInvitations(a));
    }
    public static int maximumInvitations(int[] favorite) {
        int [] indegree = new int [favorite.length];

        for (int i=0;i<favorite.length;i++){
            indegree[favorite[i]]++;
        }
        int [] deep = new int[favorite.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<favorite.length;i++){
            if (indegree[i]==0){
                deep[favorite[i]] = Math.max(deep[favorite[i]],deep[i]+1);
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int num = queue.poll();
            deep[favorite[num]] = Math.max(deep[favorite[num]],deep[num]+1);
            if (--indegree[favorite[num]]==0){
                queue.offer(favorite[num]);
            }
        }
        //到这个位置的indegree不为0就是环了
        //如果是二元环 就需要考虑deep 多元环就考虑数量
        int er =  0;
        int duo = 0;
        for (int i=0;i<indegree.length;i++){
            int size = 0;
            int cur = i;
            int deep1 = 0;
            int deep2 = 0;
           for (int j=cur;indegree[j]>=1;j=favorite[cur]){
               cur = j;
               indegree[cur] = 0;
               size++;
           }
            if (size>2){
                duo = Math.max(duo,size);
            }else if (size==2){
                er = Math.max(er,er+deep[i]+deep[cur]+2);
            }
        }
        return Math.max(er,duo);
    }
}
