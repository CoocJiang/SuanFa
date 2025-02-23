package A_leetcode.leetcodeall;

public class No376 {

    static class Node{
        int index;
        int flag;
        int count = 2;

        public Node(int index, int flag) {
            this.index = index;
            this.flag = flag;
        }
    }
    public static int wiggleMaxLength(int[] nums) {
        // write code here
        if (nums.length<2){
            return nums.length;
        } else{
            int max = 1;
            for (int i = 1;i<nums.length;i++){
                int num = nums[i]-nums[i-1];
                Node cur;
                if (num>0){
                    max = 2;
                    cur = new Node(i,1);
                }else if (num<0){
                    max = 2;
                    cur = new Node(i,0);
                }else {
                    continue;
                }
                for (int j = i+1;j<nums.length;j++){
                    if (cur.flag==0){
                        if (nums[j]>nums[cur.index]){
                            cur.count++;
                            cur.index = j;
                            cur.flag = 1;
                            max = Math.max(max, cur.count);
                        } else{
                            cur.index = j;
                        }
                    }else {
                        if (nums[j]<nums[cur.index]){
                            cur.count++;
                            cur.index = j;
                            cur.flag = 0;
                            max = Math.max(max, cur.count);
                        } else{
                            cur.index = j;
                        }
                    }
                }
                break;
            }
            return max;
        }
    }
}
