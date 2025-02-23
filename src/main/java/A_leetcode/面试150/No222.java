package A_leetcode.面试150;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class No222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static   TreeNode [] queue  = new TreeNode[50000];

   static int sizee ;
   static int left ;
   static int right ;

    public static int countNodes(TreeNode root) {
         sizee = 1;
         left  = 0;
         right = 0;
        int  size = 1;
        queue[right++] = root;
        if(root==null){
            return 0;
        }
        TreeNode cur;
        while (sizee!=0){
            cur=queue[left++];
            sizee--;
            if (cur.left!=null){
                queue[right++] = cur.left;
                sizee++;
                size++;
            }
            if (cur.right!=null){
                queue[right++] = cur.right;
                sizee++;
                size++;
            }
        }
        return size;
    }
}
