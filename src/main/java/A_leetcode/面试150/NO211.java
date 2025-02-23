package A_leetcode.面试150;


class NO211 {
    class WordDictionary {

        int end;
        WordDictionary[] nexts;

        public WordDictionary() {
            this.end = 0;
            this.nexts = new WordDictionary[26];
        }

        public void addWord(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            int index;
            WordDictionary cur = this;
            for (char o : chars) {
                index = o - 'a';
                //如果之前没有这个字符
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new WordDictionary();
                }
                cur = cur.nexts[index];
            }
            cur.end++;
        }

        public boolean search(String word) {
            if (word == null) {
                return true;
            }
            char[] chars = word.toCharArray();
            return process(this, chars, 0);
        }

        public boolean process(WordDictionary cur, char[] chars, int index) {
            if (index == chars.length) {
                return cur.end >= 1;
            }
            //如果当前是.就递归
            if (chars[index] == '.') {
                boolean flag = false;
                for (WordDictionary w : cur.nexts) {
                    if (w != null) {
                        if (process(w, chars, index + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int in = chars[index] - 'a';
                if (cur.nexts[in] == null) {
                    return false;
                }
                cur = cur.nexts[in];
                return process(cur, chars, index + 1);
            }
        }
    }
}

