package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No410_q1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("RIGHT");
        list.add("DOWN");
        System.out.println(finalPositionOfSnake(2, list));
    }
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for (int i = 0;i<commands.size();i++){
            if (commands.get(i).equals("RIGHT")){
                x++;
            } else if (commands.get(i).equals("LEFT")) {
                x--;
            } else if (commands.get(i).equals("DOWN")) {
                y++;
            } else if (commands.get(i).equals("UP")) {
                y--;
            }
        }
        return y*n+x;
    }



}
