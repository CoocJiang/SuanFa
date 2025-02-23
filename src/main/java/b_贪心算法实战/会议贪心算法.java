package b_贪心算法实战;

import java.util.Arrays;
import java.util.Comparator;

public class 会议贪心算法 {
    public static void main(String[] args) {
        会议贪心算法.Program[] programs1 = {
                new 会议贪心算法.Program(1, 3),
                new 会议贪心算法.Program(2, 4),
                new 会议贪心算法.Program(3, 6),
                new 会议贪心算法.Program(5, 7)
        };

        会议贪心算法.Program[] programs2 = {
                new 会议贪心算法.Program(1, 4),
                new 会议贪心算法.Program(3, 5),
                new 会议贪心算法.Program(0, 6),
                new 会议贪心算法.Program(5, 7),
                new 会议贪心算法.Program(8, 9),
                new 会议贪心算法.Program(3, 8)
        };

        System.out.println("第一个会议数组最多可安排的会议数：" + 会议贪心算法.bestArrange(programs1)); // 应该输出 2
        System.out.println("第二个会议数组最多可安排的会议数：" + 会议贪心算法.bestArrange(programs2)); // 应该输出 3

    }
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class mycompare implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
           return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program [] programs){
        Arrays.sort(programs,new mycompare());
        int result = 1;
        int cur = 0;
        for(int i = 1;i<programs.length;i++){
            if (programs[cur].end<=programs[i].start){
                result++;
                cur = i;
            }else {

            }
        }
        return result;
    }
}
