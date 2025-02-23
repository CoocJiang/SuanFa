package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No127 {

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String [] s=  new String[]{"hot","dog"};
        List<String> list = Arrays.asList(s);
        System.out.println(ladderLength(beginWord, endWord, list));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)){
            return 0;
        }
        int length = 2;
        HashSet<String> small = new HashSet<>();
        small.add(beginWord);
        HashSet<String> big = new HashSet<>();
        big.add(endWord);
        HashSet<String> next = new HashSet<>();
        while (small.size()!=0){
            for (String cur:small){
                char[] chars = cur.toCharArray();
                for (int i=0;i<cur.length();i++){
                    char old = chars[i];
                    for (char c='a';c<='z';c++){
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
            length++;
        }
        return 0;
    }
}
