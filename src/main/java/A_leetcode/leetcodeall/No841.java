package A_leetcode.leetcodeall;

import A_leetcode.笔试.保融;

import java.util.*;

public class No841 {

    public static void main(String[] args) {
        // 定义房间的连接关系
        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(new ArrayList<>(Arrays.asList(1)));   // 房间0与房间1和房间3相连
        rooms.add(new ArrayList<>(Arrays.asList(2))); // 房间1与房间3、房间0和房间1相连
        rooms.add(new ArrayList<>(Arrays.asList(3)));       // 房间2只与自己相连
        rooms.add(new ArrayList<>(Arrays.asList()));
        System.out.println(canVisitAllRooms(rooms));
    }

    static boolean [] visited = new boolean[1001];
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int num = 1;
        Arrays.fill(visited,false);
        visited[0] = true;
        Deque<List<Integer>> deque = new ArrayDeque<>();
        deque.addFirst(rooms.get(0));
        while (!deque.isEmpty()){
            List<Integer> cur= deque.getFirst();
            deque.removeFirst();
            for (Integer i:cur){
                if (!visited[i]){
                    visited[i]=true;
                    num++;
                    if (num==rooms.size()){
                        return true;
                    }
                    deque.addFirst(rooms.get(i));
                }
            }
        }
        return false;
    }
}
