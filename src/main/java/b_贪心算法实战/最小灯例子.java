package b_贪心算法实战;

public class 最小灯例子 {
    public static void main(String[] args) {
        String[] test2 = {"X", ".", ".", "X", ".", ".", ".", ".", ".", ".", "X", ".", ".", ".", "X"};
        System.out.println("Test 2: " + minlight(test2));
    }


    public static  int minlight(String [] str){
        int count = 0;
        for (int i=0;i< str.length;){
            if (str[i].equals("X")){
                i++;
                continue;
            }
            if (str[i].equals(".")){
                if (str[i+1].equals("X")){
                    count++;
                    i=i+2;
                }else if(str[i+1].equals(".")){
                    count++;
                    i=i+3;
                }
            }
        }
        return count;
    }
}
