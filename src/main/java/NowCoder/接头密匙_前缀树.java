package NowCoder;

public class 接头密匙_前缀树 {


    public static void main(String[] args) {
        // 定义第一个二维数组
        int[][] array1 = {
                {1, 2, 3, 4, 5},
                {2, 4, 6, 8},
                {1, 4, 7, 10}
        };
        // 定义第二个二维数组
        int[][] array2 = {
                {3, 4, 5, 6, 7, 8},
                {2, 4, 6, 8},
                {1, 3, 5, 7, 9}
        };

        for (int i : countConsistentKeys(array1, array2)) {
            System.out.println(i);
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param b int整型二维数组
     * @param a int整型二维数组
     * @return int整型一维数组
     */
    public static int[] countConsistentKeys (int[][] b, int[][] a) {
        build();
        // write code here
        int [] ans = new int[b.length];
        for (int i = 0; i < a.length; i++) {
            StringBuilder stb = new StringBuilder();
            for (int j = 1; j < a[i].length; j++) {
                stb.append(a[i][j] - a[i][j - 1]).append("#");
            }
            insert(stb.toString());
            stb.delete(0, stb.length());
        }
        for (int i = 0; i < b.length; i++) {
            StringBuilder stb = new StringBuilder();
            for (int j = 1; j < b[i].length; j++) {
                stb.append(b[i][j] - b[i][j - 1]).append("#");
            }
            ans[i] =  isstartwith(stb.toString());
            stb.delete(0, stb.length());
        }
        return ans;
    }

    static int max = 1001;
    static int [] pass = new int [max];
    static int [] end = new int[max];
    static int [][] tree = new int [max][12];
    static int cnt;
    static void build() {
        cnt = 1;
    }

    static int path(char c) {
        if (c == '#') {
            return 10;
        } else if (c == '-') {
            return 11;
        } else {
            return c - '0';
        }
    }

    static void insert(String str) {
        int cur = 1;
        pass[cur]++;
        for (int i = 0; i < str.length(); i++) {
            int path = path(str.charAt(i));
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
                cur = cnt;
            }else {
                cur = tree[cur][path];
            }
            pass[cur]++;
        }
        end[cnt]++;
    }

    static int isstartwith(String str) {
        int cur = 1;
        for (int i = 0; i < str.length(); i++) {
            int path = path(str.charAt(i));
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

}
