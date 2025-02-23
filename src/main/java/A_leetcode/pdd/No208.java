package A_leetcode.pdd;

public class No208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.search("abc");
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
    }

    static class Trie {

        Trie [] nexts;
        int pass = 0;
        int end = 0;

        public Trie() {
           nexts = new Trie[26];
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Trie cur = this;
            for (int i = 0;i<chars.length;i++){
                int index = chars[i]-'a';
                if (cur.nexts[index]==null){
                    cur.nexts[index] = new Trie();
                }
                cur = cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Trie cur = this;
            for (int i = 0;i<chars.length;i++) {
                int index = chars[i]-'a';
                if (cur.nexts[index]==null){
                    return false;
                }
                cur = cur.nexts[index];
            }
            return cur.end>1;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Trie cur = this;
            for (int i = 0;i<chars.length;i++) {
                int index = chars[i]-'a';
                if (cur.nexts[index]==null){
                    return false;
                }
                cur = cur.nexts[index];
            }
            return true;
        }
    }
}
