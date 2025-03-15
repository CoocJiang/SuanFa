package A_leetcode.面试150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class No752 {

    public static void main(String[] args) {
        String [] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        // 创建 target 字符串
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static HashSet<String> visited;
    public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        visited = new HashSet<>();
        set.addAll(Arrays.asList(deadends));
        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");
        int step = 0;
        int size = 1;
        while (!queue.isEmpty()) {
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                String cur =  queue.poll();
                if (cur.equals(target)) {
                    return step;
                }else if (visited.contains(cur)||set.contains(cur)) {
                    continue;
                }else {
                    visited.add(cur);
                    for (int j = 0;j < 4;j++) {
                        queue.add(getUp(cur,j));
                        queue.add(getDown(cur,j));
                        cnt+=2;
                    }
                }
            }
            step++;
            size = cnt;
        }
        return -1;
    }


    public static String getUp(String str,int index) {
        char c =  str.charAt(index);
        StringBuilder sb = new StringBuilder(str);
        if (c == '9') {
            c = '0';
        }else {
            c = (char) (c+1);
        }
        sb.setCharAt(index, c);
        return sb.toString();
    }

    public static String getDown(String str,int index) {
        char c =  str.charAt(index);
        StringBuilder sb = new StringBuilder(str);
        if (c == '0') {
            c = '9';
        }else {
            c = (char) (c-1);
        }
        sb.setCharAt(index, c);
        return sb.toString();
    }

}
