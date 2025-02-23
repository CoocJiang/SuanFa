package A_leetcode.leetcodeall;

import b_贪心算法实战.切金条例子;

import java.util.ArrayDeque;
import java.util.Queue;

public class NO958 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }

    static TreeNode[] queue;

    static int right;
    static int left;
    public static boolean isCompleteTree(TreeNode root) {
        right=0;
        left=0;
        queue = new TreeNode[100];
        if (root==null){
            return true;
        }
        queue[right++] = root;
        TreeNode cur ;
        boolean flag = false;
        while (left<right){
            cur = queue[left++];
            //如果某个节点有右节点但没有左节点直接返回false；
            if (flag){
                if (cur.left!=null||cur.right!=null){
                    return false;
                }
            }
            if (cur.left!=null){
                queue[right++] = cur.left;
            }else {
                if (cur.right!=null){
                    return false;
                }
            }
            if (cur.right!=null){
                queue[right++] = cur.right;
            }else {
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = root.left = new TreeNode(2);
        TreeNode node3 =root.right = new TreeNode(3);
        node3.left=new TreeNode(6);
        node2.left=new TreeNode(4);
        node2.right=new TreeNode(5);
        System.out.println(isCompleteTree(root));
    }

    public static boolean process(TreeNode root) {
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        queue1.add(root);
        int size1 = 1;
        int size2 = 0;
        boolean flag = true;
        boolean have = true;
        TreeNode cur;
        while (!queue1.isEmpty()){
            if (flag){
                while (size1>0){
                    cur = queue1.poll();
                    if (cur.left!=null){
                        if (!have){
                            return have;
                        }
                        queue1.add(cur.left);
                        size2++;
                        if (cur.right!=null){
                            queue1.add(cur.right);
                            size2++;
                        }else{
                            have = false;
                        }
                    }else {
                        if (cur.right!=null){
                            return false;
                        }else {
                            have = false;
                        }
                    }
                    size1--;
                }
            }else {
                while (size2>0){
                    cur = queue1.poll();
                    if (cur.left!=null){
                        if (!have){
                            return have;
                        }
                        queue1.add(cur.left);
                        size1++;
                        if (cur.right!=null){
                            queue1.add(cur.right);
                            size1++;
                        }else{
                            have = false;
                        }
                    }else {
                        if (cur.right!=null){
                            return false;
                        }else {
                            have = false;
                        }
                    }
                    size2--;
                }
            }
            flag = !flag;
        }
        return true;
    }
}
