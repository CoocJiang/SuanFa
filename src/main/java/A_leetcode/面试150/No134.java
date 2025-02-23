package A_leetcode.面试150;

public class No134 {
    public static void main(String[] args) {
        int[] gas =new int[] {1,2,3,4,5};
        int[]  cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
        //{1,2,3}
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int sum = 0;
        int cur = 0;
        int times = 0;
        for (int i=0;i<=length+times;i++){
            if (sum == 0&&times!=length){
                cur = i;
            }
            sum = sum+gas[i%length];
            if (sum>=cost[i%length]){
                sum = sum - cost[i%length];
                times++;
                if (times==length){
                    return cur;
                }
                continue;
            }else {
                times=0;
                sum = 0;
            }
        }
        return -1;
    }
}
