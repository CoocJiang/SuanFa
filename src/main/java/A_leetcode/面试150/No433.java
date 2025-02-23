package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No433 {

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation(startGene, endGene, bank));
    }


    static char[] move= new char[]{'A','C','G','T'};
    public static int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> dic = new HashSet<>(Arrays.asList(bank));
        if (!dic.contains(endGene)){
            return 0;
        }
        int length = 0;
        HashSet<String> small = new HashSet<>();
        small.add(startGene);
        HashSet<String> big = new HashSet<>();
        big.add(endGene);
        HashSet<String> next = new HashSet<>();
        while (small.size()!=0){
            length++;
            for (String cur:small){
                char[] chars = cur.toCharArray();
                for (int i=0;i<cur.length();i++){
                    char old = chars[i];
                    for (char c:move){
                        chars[i] = c;
                        String s =new String(chars);
                        if (dic.contains(s)&&!s.equals(cur)){
                            next.add(s);
                            if (big.contains(s)){
                                return length;
                            }
                        }
                    }
                    chars[i] = old;
                }
                dic.remove(cur);
            }
            HashSet<String> temp = next;
            next  = small;
            small = temp;
            if (small.size()> big.size()){
                HashSet<String> temp1 = small;
                small = big;
                big = temp1;
            }
            next.clear();
        }
        return 0;
    }
}
