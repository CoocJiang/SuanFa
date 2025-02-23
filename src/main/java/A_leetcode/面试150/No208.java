package A_leetcode.面试150;

import java.util.Arrays;

public class No208 {
    class Trie {

        int pass;
        int end;
        Trie [] nexts;

        public Trie() {
            this.end = 0;
            this.pass=0;
            this.nexts = new Trie[26];
        }

        public void insert(String word) {
            if (word==null){
                return;
            }
            char[] chars = word.toCharArray();
            int index;
            Trie cur = this;
            for (char o: chars){
                index = o-'a';
                //如果之前没有这个字符
                if (cur.nexts[index]==null){
                    cur.nexts[index] = new Trie();
                    cur.nexts[index].pass++;
                }else {
                    //如果有
                    cur.nexts[index].pass++;
                }
                cur = cur.nexts[index];
            }
            cur.end++;
        }

        public boolean search(String word) {
            if (word==null){
                return true;
            }
            char[] chars = word.toCharArray();
            int index;
            Trie cur = this;
            for (char o: chars){
                index = o-'a';
                //如果没有这个字符
                if (cur.nexts[index]==null){
                   return false;
                }
                //有就直接下一个
                cur = cur.nexts[index];
            }
            if (cur.end>=1){
                return true;
            }else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
            if (prefix==null){
                return true;
            }
            char[] chars = prefix.toCharArray();
            int index;
            Trie cur = this;
            for (char o: chars){
                index = o-'a';
                //如果之前没有这个字符
                if (cur.nexts[index]==null){
                  return false;
                }
                cur = cur.nexts[index];
            }
           return true;
        }
    }

    static class Tree{

        public static int maxn = 150001;

        static int [][] tree = new int[maxn][26];

        static int [] pass = new int[maxn];

        static int [] end = new int[maxn];

        static int cnt ;

        public static void build() {
            cnt = 1;
        }

        public static void insert(String word) {
            int cur = 1;
            pass[cur]++;
            //从根节点开始
            for (int i=0;i<word.length();i++){
                int path = word.charAt(i)-'a';
                if (tree[cur][path]==0){
                    //第一次来
                    tree[cur][path] = ++cnt;
                    cur = tree[cur][path];
                    pass[cur]++;
                }else {
                    cur = tree[cur][path];
                    pass[cur]++;
                }
            }
            end[cur]++;
        }

        public static int search(String word) {
            int cur = 1;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    return 0;
                }
                cur = tree[cur][path];
            }
            return end[cur];
        }


        public static int prefixNumber(String prefix) {
            int cur = 1;
            //从根节点开始匹配
            for (int i = 0; i < prefix.length(); i++) {
                int path = prefix.charAt(i) - 'a';
                if (tree[cur][path] != 0) {
                    cur = tree[cur][path];
                } else {
                    return 0;
                }
            }
            return pass[cur];
        }
        public static void delete(String word) {
            if (search(word) > 0) {
                int cur = 1;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if (--pass[tree[cur][path]] == 0) {
                        tree[cur][path] = 0;
                        return;
                    }
                    cur = tree[cur][path];
                }
                end[cur]--;
            }
        }

        public static void clear() {
            for (int i = 1; i <= cnt; i++) {
                Arrays.fill(tree[i], 0);
                end[i] = 0;
                pass[i] = 0;
            }
        }
    }
}
