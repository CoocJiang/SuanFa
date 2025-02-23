package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No652 {
    
    static HashMap<String,Integer> map;
    static List<TreeNode> list;
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        dfs(root);
        return list;
    }


    public static String dfs(TreeNode root){
        if (root==null){
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_").append(root.val);
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        map.put(key,map.getOrDefault(key,0)+1);
        int num = map.get(key);
        if (num==2){
            list.add(root);
        }
        return key;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left=new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right=new TreeNode(4);
        findDuplicateSubtrees(root);
    }
}
