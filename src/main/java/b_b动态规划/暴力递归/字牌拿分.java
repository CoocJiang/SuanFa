package b_b动态规划.暴力递归;

public class 字牌拿分 {

    public static void main(String[] args) {
        int [] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(win3(arr));
    }

    public static int win1(int [] arr ){
        int a= g(arr,0, arr.length-1);
        int b = f(arr,0, arr.length-1);
        return Math.max(a,b);
    }
    public static int f(int [] arr,int L,int R){
        if (L==R){
            return arr[L];
        }else {
           return Math.max(arr[L]+g(arr,L+1,R),arr[R]+g(arr,L,R-1));
        }
    }
    public static int g(int [] arr,int L,int R){
        if (L==R){
            return arr[L];
        }else {
            return Math.min(f(arr,L+1,R),f(arr,L,R-1));
        }
    }
    //改进之后的方法，动态规划初级
    public static int win2(int [] arr ){
        int [][] fmap = new int[arr.length][arr.length];
        int [][] gmap = new int[arr.length][arr.length];
        for (int i=0;i< arr.length;i++){
            for (int j=1;j< arr.length;j++){
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int a= g2(arr,0, arr.length-1,fmap,gmap);
        int b = f2(arr,0, arr.length-1,fmap,gmap);
        return Math.max(a,b);
    }
    public static int f2(int [] arr,int L,int R,int[][] fmap,int [][]gmap){
        if (fmap[L][R]!=-1){
            return fmap[L][R];
        }
        if (L==R){
            return arr[L];
        }else {
            fmap[L][R] = Math.max(arr[L]+g2(arr,L+1,R,fmap,gmap),arr[R]+g2(arr,L,R-1,fmap,gmap));
            return fmap[L][R];
        }
    }
    public static int g2(int [] arr,int L,int R,int[][] fmap,int [][]gmap){
        if (gmap[L][R]!=-1){
            return gmap[L][R];
        }
        if (L==R){
            return arr[L];
        }else {
            gmap[L][R] = Math.min(f2(arr,L+1,R,fmap,gmap),f2(arr,L,R-1,fmap,gmap));
            return gmap[L][R];
        }
    }

    //方法三，动态规划再次优化
    public static int win3(int []arr){
        int [][] fmap = new int[arr.length][arr.length];
        int [][] gmap = new int[arr.length][arr.length];
        for (int i = 0;i<arr.length;i++){
            fmap[i][i]=arr[i];
            gmap[i][i]=arr[i];
        }
        for (int i=1;i<arr.length;i++){
            for (int j = i-1;j>=0;j--){
              fmap[j][i]=Math.max(arr[j]+gmap[j+1][i],arr[i]+gmap[j][i-1]);
              gmap[j][i] = Math.min(fmap[j+1][i],fmap[j][i-1]);
            }
        }
        return Math.max(gmap[0][arr.length-1],fmap[0][arr.length-1]);
    }
}
