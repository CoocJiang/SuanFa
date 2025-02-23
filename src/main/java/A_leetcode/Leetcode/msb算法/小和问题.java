package A_leetcode.Leetcode.msb算法;

public class 小和问题 {
    public static void main(String[] args) {
        int [] arr = {5,4,3,5,3,2,1};
        processer(arr, 0, arr.length - 1);
    }
    public static void processer(int arr[],int L,int R){
        if (L==R){
            return ;
        }
        int mid = (L+R)/2;
        processer(arr,L,mid);
        processer(arr,mid+1,R);
        System.out.println( merge3(arr, L, R, mid));
    }
    public static int merge(int[] arr,int L,int R,int M){
        int [] help = new int[R-L+1];
        int i =0;
        int Mid  = M+1;
        int index = L;
        int left = L;
        int ans = 0;
        while (L <= M && Mid <= R){
            if (arr[L]<arr[Mid]){
                help[i] = arr[L];
                L++;
                i++;
            }else {
                for (;index<L;index++ ){
                    ans = arr[index]+ans;
                }
                index=left;
                help[i] = arr[Mid];
                Mid++;
                i++;
            }
        }
        while (L <= M){
            help[i] = arr[L];
            L++;
            i++;
        }
        while (Mid < R+1 ){
            for (;index<L;index++ ){
                ans = arr[index]+ans;
            }
            index=left;
            help[i] = arr[Mid];
            Mid++;
            i++;
        }
        for(int j =0;j< help.length;j++){
            arr[index+j] = help[j];
        }
        return ans;
    }
    public static int merge1(int[] arr,int L,int R,int M) {
        int [] help = new int[R-L+1];
        int i =0;
        int Mid  = M+1;
        int index = L;
        int left = L;
        int ans = 0;
        int windowR = M + 1;
        for (int j =L;j<=M; j++){
        while (windowR <= R && arr[j] > (arr[windowR] * 2)) {
            windowR++;
        }
            ans =ans + windowR - M - 1;
        }
        while (L <= M && Mid <= R){
            if (arr[L]<arr[Mid]){
                help[i] = arr[L];
                L++;
                i++;
            }else {
                help[i] = arr[Mid];
                Mid++;
                i++;
            }
        }
        while (L <= M){
            help[i] = arr[L];
            L++;
            i++;
        }
        while (Mid < R+1 ){
            help[i] = arr[Mid];
            Mid++;
            i++;
        }
        for(int j =0;j< help.length;j++){
            arr[index+j] = help[j];
        }

        return ans;
    }
    public static int merge3(int[] arr,int L,int R,int M) {
        int [] help = new int[R-L+1];
        int i =0;
        int Mid  = M+1;
        int index = L;
        int left = M;
        int right = R;
        int ans = 0;
        while (left>=L){
             while (arr[right]>=arr[left]&&right>M){
                 right--;
             }
             ans = ans+ right-M;
             left--;
        }
        while (L <= M && Mid <= R){
            if (arr[L]<arr[Mid]){
                help[i] = arr[L];
                L++;
                i++;
            }else {
                help[i] = arr[Mid];
                Mid++;
                i++;
            }
        }
        while (L <= M){
            help[i] = arr[L];
            L++;
            i++;
        }
        while (Mid < R+1 ){
            help[i] = arr[Mid];
            Mid++;
            i++;
        }
        for(int j =0;j< help.length;j++){
            arr[index+j] = help[j];
        }
        return ans;
    }

}
