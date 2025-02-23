package xiaomi;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class No1 {
    static HashSet<String> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int [][] arr  = new int[3][3];
        HashSet<Integer> set = new HashSet<>();
        for (int i=1;i<10;i++){
            set.add(i);
        }
        for (int i = 0;i<n;i++){
            ans = new HashSet<>();
            boolean [] nums = new boolean[10];
            List<int []> list = new ArrayList<>();
            s = bf.readLine().split(" ");
            for (int j =0;j<3;j++){
                arr[0][j] = Integer.parseInt(s[j]);
                if (arr[0][j] == 0 ){
                    list.add(new int[]{0,j});
                }else {
                    nums [arr[0][j]] = true;
                }
            }
            s = bf.readLine().split(" ");
            for (int j =0;j<3;j++){
                arr[1][j] = Integer.parseInt(s[j]);
                if (arr[1][j] ==0 ){
                    list.add(new int[]{1,j});
                }else {
                    nums [arr[1][j]] = true;
                }
            }
            s = bf.readLine().split(" ");
            for (int j =0;j<3;j++){
                arr[2][j] = Integer.parseInt(s[j]);
                if (arr[2][j] ==0 ){
                    list.add(new int[]{2,j});
                }else {
                    nums [arr[2][j]] = true;
                }
            }
            process(arr,list,0,nums,new StringBuilder());
            out.println(ans.size());
        }
        out.close();
    }


    static int [] move = new int[]{1,0,-1,0,1};

    public static void process(int[][] arr,List<int []> list,int index,boolean [] nums,StringBuilder stringBuilder){
        if (list.size()==index){
            ans.add(stringBuilder.toString());
            return;
        }
        int x,y;
        int [] cur = list.get(index);
        x = cur[0];
        y = cur[1];
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 1;i<move.length;i++){
            int nx = x+move[i-1];
            int ny = y+move[i];
            if (nx<3&&nx>=0&&ny>=0&&ny<3){
                set1.add(arr[nx][ny]);
            }
        }
       for (int i = 1;i<nums.length;i++){
           if (!nums[i]){
               if (!(set1.contains(i+1)||set1.contains(i-1))){
                   stringBuilder.append(i);
                   nums[i] = true;
                   process(arr,list,index+1,nums,stringBuilder);
                   stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
                   nums[i] = !nums[i];
               }
           }
        }
    }
}
