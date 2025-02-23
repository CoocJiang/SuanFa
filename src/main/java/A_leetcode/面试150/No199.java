package A_leetcode.面试150;

import java.util.*;

public class No199 {
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

//    BFS
    public  static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> anslist = new ArrayList<>();
        if (root==null){
            return anslist;
        }
        queue1.add(root);
        boolean flag1 = true;
        boolean flag2 = true;
        TreeNode cur;
        while (!queue1.isEmpty()|| !queue2.isEmpty()){
            if (flag1){
                while (!queue1.isEmpty()){
                    cur = queue1.poll();
                    if (flag2){
                        anslist.add(cur.val);
                        flag2=false;
                    }
                    if (cur.right!=null){
                        queue2.add(cur.right);
                    }
                    if (cur.left!=null){
                        queue2.add(cur.left);
                    }
                }
                flag1=false;
                flag2 = true;
            }else {
                while (!queue2.isEmpty()){
                    cur = queue2.poll();
                    if (flag2){
                        anslist.add(cur.val);
                        flag2=false;
                    }
                    if (cur.right!=null){
                        queue1.add(cur.right);
                    }
                    if (cur.left!=null){
                        queue1.add(cur.left);
                    }
                }
                flag1=true;
                flag2 = true;
            }
        }
        return anslist;
    }
    //DFS
//    public  static List<Integer> rightSideView(TreeNode root){
//        List<Integer> anslist = new ArrayList<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        if (root==null){
//            return anslist;
//        }
//        int deepth = 0;
//        process(map,root,0);
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
//            anslist.add(entry.getValue());
//        }
//        return anslist;
//    }
//
//    public static void process(HashMap<Integer,Integer> map,TreeNode root,int deepth ){
//        if (map.containsKey(deepth)){
//            if (root.right!=null){
//                process(map,root.right,deepth+1);;
//            }
//            if (root.left!=null){
//                process(map,root.left,deepth+1);;
//            }
//        }else {
//            map.put(deepth,root.val);
//            if (root.right!=null){
//                process(map,root.right,deepth+1);;
//            }
//            if (root.left!=null){
//                process(map,root.left,deepth+1);;
//            }
//        }
//    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right  = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right=new TreeNode(4);
        for (int a:rightSideView(root)){
            System.out.println(a);
        }
    }
}
