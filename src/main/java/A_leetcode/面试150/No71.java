package A_leetcode.面试150;

public class No71 {

    public static void main(String[] args) {
        String path = "/./yPvI/./X/../cCwm/../../.";
        System.out.println(simplifyPath(path));
    }
    public static String simplifyPath(String path) {
        char[] stacks = new char[path.length()];
        char[] chars = path.toCharArray();
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            if (r - 1 >= 0) {
                //如何上一级都是斜杠
                if (stacks[r - 1] == '/') {
                    if (chars[i] == stacks[r - 1]) {
                        continue;
                    }else if (chars[i]=='.'&&(i+1>= chars.length||chars[i+1]=='/')){
                        r--;
                        continue;
                    }
                }
            }
            if (r - 2 >= 0) {
                if (stacks[r - 2] == '/' && stacks[r - 1] == '.') {
                    if (chars[i] == '.') {
                        if (i + 1 >= chars.length||chars[i + 1] == '/') {
                            r = r - 3 < 0 ? 0 : r - 3;
                            while (stacks[r] != '/') {
                                r--;
                            }
                            continue;
                        }
                    }
                }
            }
            stacks[r++] = chars[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < r - 1; i++) {
            stringBuilder.append(stacks[i]);
        }
        if (r-1>0&&stacks[r - 1] != '/') {
            stringBuilder.append(stacks[r - 1]);
        }
        return stringBuilder.toString().equals("") ? "/":stringBuilder.toString();
    }
}
