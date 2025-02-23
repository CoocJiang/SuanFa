package A_leetcode.leetcodeall;

public class No134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit( new int[]{2,3,4},new int[]{3,4,3}));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        
        int cnts = 0;
        int gass = 0;
        int length = gas.length;
        int start = 0;
        for(int i = 0;i<2*gas.length;i++){
            gass+= gas[i%length] - cost[i%length];
            if(gass<0){
                cnts = 0;
                start = i+1;
                gass = 0;
                continue;
            }
            if(++cnts==length){
                return start;
            }
        }
        return -1;
    }
}
