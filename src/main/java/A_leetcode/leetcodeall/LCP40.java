package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Collections;

public class LCP40 {


    public static void main(String[] args) {
        System.out.println(maxmiumScore(new int[]{1,4,1,15,7,12,19,15,8,16,16,9,13,1,14,12,17,9,20,2,11,7,15,14,12,8,14,15,17,7,10,16,5,6,13,2,15,6,20,10,7,11,17,17,4,8,3,1,3,6,8,16,4,13,16,16,3,9,5,6,10,9,9,10,7,1,20,6,5,4,11,17,11,20,8,12,3,14,7,7,17,8,16,6}, 65));
    }
    static int [][] dp;
    public static int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int sum = 0;
        int minji = -1;
        int minou = -1;
        int i = cards.length-1;
        for (;cnt>0;cnt--,i--){
            sum+=cards[i];
            if (cards[i]%2==0){
                //是偶数
                minou = cards[i];
            }else {
                minji = cards[i];
            }
        }
        if (sum%2==0){
            return sum;
        }else {
            int maxou = -1;
            int maxji = -1;
            int count = 0;
            while (i>=0&&(maxji==-1||maxou==-1)){
                if (cards[i]%2==0){
                    maxou = Math.max(maxou,cards[i]);
                }else {
                    maxji = Math.max(maxji,cards[i]);
                }
                i--;
            }
            if (maxji!=-1&&minou!=-1){
                if (maxou!=-1&&minji!=-1){
                    return Math.max(sum+maxji-minou,sum+maxou-minji);
                }else {
                    return sum+maxji-minou;
                }
            }else{
                if (maxou!=-1&&minji!=-1){
                    return sum+maxou-minji;
                }else {
                    return 0;
                }
            }
        }
    }

}
