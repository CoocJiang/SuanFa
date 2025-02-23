package A_leetcode.leetcodeall;

public class No1234 {

    public static void main(String[] args) {
        System.out.println(balancedString("WQWRQQQW"));
    }
    public static int balancedString(String s) {
        int ans = s.length();
        char [] chars = s.toCharArray();
        int n = chars.length;
        int require = n/4;
        int [] arr = new int[4];
        boolean flag = true;
        for(int i = 0;i<n;i++){
            process(arr,chars,i,1);
        }
        for(int l = 0,r=0;r<n;){
            process(arr,chars,r++,-1);
            while(isok(l,r,require,arr)&&l<n){
                ans = Math.min(ans,r-l);
                process(arr,chars,l,1);
                l++;
            }
        }
        return ans;
    }

    public static int process(int [] arr,char[] chars ,int i,int num){
        if(chars[i]=='Q'){
            arr[0] +=num ;
            return arr[0];
        }else if(chars[i]=='W'){
            arr[1]+=num ;
            return arr[1];
        }else if(chars[i]=='E'){
            arr[2]+=num ;
            return arr[2];
        }else {
            arr[3]+=num ;
            return arr[3];
        }
    }
    public static boolean isok(int l,int r,int require,int [] arr){
        int sum = r-l;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>require){
                return false;
            }else{
                sum -=(require-arr[i]);
            }
        }
        if(sum<0){
            return false;
        }
        return true;
    }
}
