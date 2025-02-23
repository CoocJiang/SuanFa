package A_leetcode.leetcodeall;

import java.util.*;

public class No103 {
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

    static TreeNode[] queue = new TreeNode[2001];


    static int r = 0;

    static int l = 0;
    static int size;

    public static void add(TreeNode num) {
        size++;
        queue[r++] = num;
    }

    public static TreeNode pool() {
        size--;
        return queue[l++];
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        size = 0;
        r=0;
        l=0;
        if (root==null){
            return new ArrayList<>();
        }
        boolean flag = true;
        //false从左往右，true从右往左
        add(root);
        TreeNode cur;
        int size1 = 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (l<r){
            flag = !flag;
            int seize = size1;
            size1 = 0;
            List <Integer>list = new ArrayList<>();
            for (int i=0;i<seize;i++){
                cur = pool();
                if (cur.left!=null){
                    add(cur.left);
                    size1++;
                }
                if (cur.right!=null){
                    add(cur.right);
                    size1++;
                }
                list.add(cur.val);
            }
            if (flag){
                Collections.reverse(list);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3); // 根节点
        root.left = new TreeNode(9);      // 左子节点
        root.right = new TreeNode(20);     // 右子节点

//        root.left.left = new TreeNode(4);    // 左子节点的左子节点
//        root.left.right = new TreeNode(5);   // 左子节点的右子节点

        root.right.left = new TreeNode(15);   // 右子节点的左子节点
        root.right.right = new TreeNode(7);  // 右子节点的右子节点
        for (List<Integer> list :levelOrder(root)){
            for (Integer a:list){
                System.out.println(a);
            }
        }
    }
}
