package tencentTest1;


import java.util.Map;

public class test3 {

    static class Node{
        int r;
        int e;
        int d;

        public Node(int r, int e, int d) {
            this.r = r;
            this.e = e;
            this.d = d;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        System.out.println(matrixCount(new String[]{"red","edr","dre"}, 1));
    }
    public static int matrixCount (String[] a, int myval) {
        // write code here
        int n = a.length;
        int count = 0;
        char [] chars;
        Node[][] nums = new Node[n][n];
        char[] chars1 = a[0].toCharArray();
        nums[0][0] = new Node();
        if (chars1[0]=='r'){
            nums[0][0].r++;
        }else if (chars1[0]=='e'){
            nums[0][0].e++;
        }else if (chars1[0]=='d'){
            nums[0][0].d++;
        }
        for (int i = 1;i<a.length;i++){
            nums[0][i] = new Node(nums[0][i-1].r,nums[0][i-1].e,nums[0][i-1].d);
            if (chars1[i]=='r'){
                nums[0][i].r++;
            }else if (chars1[i]=='e'){
                nums[0][i].e++;
            }else if (chars1[i]=='d'){
                nums[0][i].d ++;
            }
            if (Math.min(nums[0][i].r,Math.min(nums[0][i].e,nums[0][i].d))>myval){
                count++;
            }
        }
        for (int i = 1;i<a.length;i++){
            nums[i][0] = new Node(nums[i-1][0].r,nums[i-1][0].e,nums[i-1][0].d);
            if (a[i].charAt(0)=='r'){
                nums[i][0].r++;
            }else if (a[i].charAt(0)=='e'){
                nums[i][0].e++;
            }else if (a[i].charAt(0)=='d'){
                nums[i][0].d ++;
            }
            if (Math.min(nums[i][0].r,Math.min(nums[i][0].e,nums[i][0].d))>=myval){
                count++;
            }
        }

        for (int i = 1;i<n;i++){
            chars = a[i].toCharArray();
            for (int j = 1;j<n;j++){
                nums[i][j] = new Node(nums[i][j-1].r+nums[i-1][j].r-nums[i-1][j-1].r,nums[i][j-1].e+nums[i-1][j].e-nums[i-1][j-1].e,nums[i][j-1].d+nums[i-1][j].d-nums[i-1][j-1].d);
                if (chars[i]=='r'){
                    nums[i][j].r++;
                }else if (chars[i]=='e'){
                    nums[i][j].e++;
                }else if (chars[i]=='d'){
                    nums[i][j].d ++;
                }
                if (Math.min(nums[i][j].r,Math.min(nums[i][j].e,nums[i][j].d))>=myval){
                    count++;
                    int k = 0;
                    while (Math.min(nums[i][j].r-nums[i][k].r,Math.min(nums[i][j].e-nums[i][k].e,nums[i][j].d-nums[i][k].d))>=myval){
                        count++;
                        k++;
                    }
                }
            }
        }
        return count;
    }
}
