package A_leetcode.tencent;

import java.util.Queue;

public class test1 {

    static int mod = 1000000007;
    public static int cntOfTrees (int n) {
        // write code here

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(kawaiiStrings(4));
    }
    static int count;
    public static int kawaiiStrings (int n) {
        // write code here
        count = 0;
        process2(0,new char[n],n);
        return count;
    }

    public static void   process2(int index,char [] chars,int n){
        if (index==n){
            count = (count+1)%mod;
        }else {
            if (index>1&&chars[index-1]=='e'&&chars[index-2]=='r'){
                chars[index] = 'r';
                process2(index+1,chars,n);
                chars[index] = 'e';
                process2(index+1,chars,n);
            }else {
                chars[index] = 'r';
                process2(index+1,chars,n);
                chars[index] = 'e';
                process2(index+1,chars,n);
                chars[index] = 'd';
                process2(index+1,chars,n);
            }
        }
    }

}
