package A_leetcode.面试150;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public  class No173 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);

        // 创建左子节点
        root.left = new TreeNode(3);

        // 创建右子节点
        root.right = new TreeNode(15);

        // 创建左子节点的右子节点
        root.right.left = new TreeNode(9);

        // 创建右子节点的右子节点
        root.right.right = new TreeNode(20);

        new BSTIterator(root);
    }

   static class BSTIterator {

        public static int [] queue = new int[100000];

        int left;

        int right;

        int size;

        public BSTIterator(TreeNode root) {
            left = 0;
            right = 0;
            size = 0;
            process1(root);
        }

        public int next() {
            size--;
            return queue[left++];
        }

        public boolean hasNext() {
            return size != 0;
        }

        public void process1(TreeNode root){
            if (root.left!=null){
                process1(root.left);
            }
            queue[right++] = root.val;
            size++;
            if (root.right!=null){
                process1(root.right);
            }
        }
    }
}
