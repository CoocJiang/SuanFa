package A_leetcode.leetcodeall;

import java.util.LinkedList;
import java.util.Queue;

public class No2024 {


    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTTTTFTFFT",2));
    }
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int l = 0;
        int r = 0;
        int oldk = k;
        Queue<Integer> queue = new LinkedList<>();
        char[] chars = answerKey.toCharArray();
        int n = chars.length;
        int max = 0;
        while (r<n){
            if (chars[r]=='F'){
                if (k==0){
                    Integer poll = queue.poll();
                    while (l<=poll){
                        l++;
                    }
                    k++;
                }
                k--;
                queue.add(r);
                r++;
                max = Math.max(max,r-l);
            }else {
                r++;
                max = Math.max(max,r-l);
            }
        }
        queue.clear();
        l = 0;
        r = 0;
        k = oldk;
        while (r<n){
            if (chars[r]=='T'){
                if (k==0){
                    Integer poll = queue.poll();
                    while (l<=poll){
                        l++;
                    }
                    k++;
                }
                k--;
                queue.add(r);
                r++;
                max = Math.max(max,r-l);
            }else {
                r++;
                max = Math.max(max,r-l);
            }
        }
        return max;
    }


}
