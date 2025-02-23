package A_leetcode.leetcodeall;

import java.util.*;

public class LCR114 {

    public static void main(String[] args) {
        String  [] a = {"z","x","a","zb","zx"};
        System.out.println(alienOrder(a));
    }
    public static String alienOrder(String[] words) {

        int [] indegree = new int [26];
        Arrays.fill(indegree,-1);
        List<List<Integer>> list  = new ArrayList<>();
        //初始化邻接表
        for (int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }
        for (int i=0;i<words.length;i++){
            for (int j=0;j<words[i].length();j++){
                //设置所有在words里出现过的字符的入度为0
                indegree[words[i].charAt(j)-'a'] = 0;
            }
        }
        for (int i=0;i<words.length-1;i++){
            String cur = words[i];
            String next = words[i+1];
            int j=0;
            for (;j<Math.min(cur.length(),next.length());j++){
                if (cur.charAt(j)!=next.charAt(j)){
                    //说明此时字典序cur.charAt(j)在前
                    list.get(cur.charAt(j)-'a').add(next.charAt(j)-'a');
                    //next.charAt(j)入度加1
                    indegree[next.charAt(j)-'a']++;
                    break;
                }
            }
            if (j==Math.min(cur.length(),next.length())&&cur.length()>next.length()){
                return "";
            }
        }
        //此时已经得到所有的入度信息，不存在的点都是-1
        //把入度为0的加入队列
        int kinds = 0;
        Queue<Integer>  queue = new LinkedList<>();
        for (int i=0;i<26;i++){
            if (indegree[i]!=-1){
                kinds++;
            }
            if (indegree[i]==0){
                queue.add(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()){
            int nums = queue.poll();
            stringBuilder.append((char) ('a'+nums));
            for (int i:list.get(nums)){
                if (--indegree[i]==0){
                    queue.offer(i);
                }
            }
        }
        //如果产生循环依赖就会出现不相等的情况
        if (kinds==stringBuilder.length()){
            return stringBuilder.toString();
        }else {
            return "";
        }

    }
}
