package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No881 {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,3,2,2}, 6));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0;
        int r = people.length-1;
        while(l<=r){
            int next = limit;
            int time = 0;
            while(time<2&&r>=l&&next>=people[r]){
                next = next - people[r--];
                time++;
            }
            while(time<2&&r>=l&&next>=people[l]){
                next = next - people[l++];
                time++;
            }

            ans++;
        }
        return ans;
    }
}
    