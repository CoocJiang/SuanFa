package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No36 {
    //请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
    //
    //
    //注意：
    //
    //一个有效的数独（部分已被填充）不一定是可解的。
    //只需要根据以上规则，验证已经填入的数字是否有效即可。
    //空白格用 '.' 表示。
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, List<Character>> hang = new HashMap<>();
        HashMap<Integer, List<Character>> lie = new HashMap<>();
        HashMap<Integer, List<Character>> square = new HashMap<>();
        for (int i = 0 ;i<10;i++){
            hang.put(i,new ArrayList<>());
            lie.put(i,new ArrayList<>());
            square.put(i,new ArrayList<>());
        }
        for (int i=0;i<board.length;i++){
            for (int j= 0;j<board[0].length;j++){
                if (board[i][j]=='.'){
                    continue;
                }
                if (hang.get(i).contains(board[i][j])){
                    return false;
                }else {
                    hang.get(i).add(board[i][j]);
                }
                if (lie.get(j).contains(board[i][j])){
                    return false;
                }else {
                    lie.get(j).add(board[i][j]);
                }
                int where = (i/3)*3+(j/3);
                if (square.get(where).contains(board[i][j])){
                    return false;
                }else {
                    square.get(where).add(board[i][j]);
                }
            }
        }
        return true;
    }
}
