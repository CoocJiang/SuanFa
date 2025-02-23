package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No676 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] commands = {"hello","hallo","leetcode"};
        magicDictionary.buildDict(commands);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hallo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcodd"));
    }
    static class MagicDictionary {

        Trie root ;
        boolean modify;
        public MagicDictionary() {
            root = new Trie();
        }

        public void buildDict(String[] dictionary) {
            char [] chars;
            for (int i = 0;i< dictionary.length;i++){
                chars = dictionary[i].toCharArray();
                Trie cur = root;
                for (int j = 0;j<chars.length;j++){
                    if (cur.next[chars[j]-'a']==null){
                        cur.next[chars[j]-'a'] = new Trie();
                    }
                    cur = cur.next[chars[j]-'a'];
                    cur.p++;
                }
                cur.end++;
            }
        }

        public boolean search(String searchWord) {
            modify = false;
            return dfs(root,searchWord.toCharArray(),0,modify);
        }

        public boolean dfs(Trie cur,char [] chars,int index,boolean modify){
            //来到某个字母
            if (index==chars.length-1){
                if (modify){
                    if (cur.next[chars[index]-'a']!=null&&cur.next[chars[index]-'a'].end>0){
                        return modify;
                    }
                }else {
                    for (int i = 0;i<26;i++){
                        if (cur.next[i]!=null&&(i!=chars[index]-'a')){
                            return true;
                        }
                    }
                }
            }else {
                if (cur.next[chars[index]-'a']!=null){
                    if (dfs(cur.next[chars[index]-'a'],chars,index+1,modify)) return true;
                }
                if (!modify){
                    modify = true;
                    for (int i = 0;i<26;i++){
                        if (cur.next[i]!=null&&(i!=chars[index]-'a')){
                            if (dfs(cur.next[i],chars,index+1,modify)) return true;
                        }
                    }
                }else {
                    return false;
                }
            }
            return false;
        }

        class Trie{
            int end;
            int p ;
            Trie [] next ;

            public Trie(){
                end = 0;
                p = 0;
                next = new Trie[26];
            }
        }
    }
}
