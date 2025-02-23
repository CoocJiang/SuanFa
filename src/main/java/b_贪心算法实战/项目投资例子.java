package b_贪心算法实战;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 项目投资例子 {
    public static void main(String[] args) {
       int K = 4;
       int W = 2 ;
       int [] Profits = {2, 3, 4, 5};
       int [] Capital = {0, 1, 1, 2};
       System.out.println(findMaximizedCapital(K,W,Profits,Capital));
    }
    public static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital){
        PriorityQueue<Program> minheat = new PriorityQueue<>(new mymincompare());
        PriorityQueue<Program> maxheat = new PriorityQueue<>(new mymaxcompare());
        for (int i =0;i<Profits.length;i++){
            minheat.add(new Program(Profits[i],Capital[i]));
        }
        for (int i=0;i<=K;i++){
            while (!minheat.isEmpty() && minheat.peek().c <= W){
                maxheat.add(minheat.poll());
            }
            if (maxheat.isEmpty()) {
                break; // 如果没有项目可以做了，直接退出循环
            }
            W = maxheat.peek().p+W-maxheat.poll().c;
        }
        return W;
    }
    public static class mymaxcompare implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o2.p- o1.p;
        }
    }
    public static class mymincompare implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c- o2.c;
        }
    }
}
