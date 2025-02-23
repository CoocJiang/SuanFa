package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No230 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<Integer> ans ;
    static int size;
//    public static int kthSmallest(TreeNode root, int k) {
//        ans = new ArrayList<>();
//        size=k;
//        process(root,ans);
//        return ans.get(k-1);
//    }

//    public static void process(TreeNode root, List<Integer> ans){
//        if (root.left!=null){
//            process(root.left,ans);
//        }
//        ans.add(root.val);
//        if (ans.size()>=size){
//            return;
//        }
//        if (root.right!=null){
//            process(root.right,ans);
//        }
//    }
//

    static List<Integer> list;
    public static int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        traverse(root,k);
        return list.get(k-1);
    }

    public static void traverse(TreeNode root,int k){
       //到一个节点先看他有没有左节点有的话就往下
        if (root.left!=null){
            traverse(root.left,k);
        }
        list.add(root.val);
        if (list.size()>=k){
            return;
        }
        if (root.right!=null){
            traverse(root.right,k);
        }
    }


    public static void main(String[] args) {
        TreeNode root  =new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.left.right=new TreeNode(2);
        System.out.println(kthSmallest(root, 1));
    }
}
