package 位运算.class11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 本题测试链接：https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
public class Code03_EncodeNaryTreeToBinaryTree {

	// 提交时不要提交这个类
	public static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	// 提交时不要提交这个类
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 只提交这个类即可
	static class  Codec {
		// Encodes an n-ary tree to a binary tree.
		public TreeNode encode(Node root) {
			if (root == null) {
				return null;
			}
			TreeNode head = new TreeNode(root.val);
			head.left = en(root.children);
			return head;
		}

		private TreeNode en(List<Node> children) {
			TreeNode head = null;
			TreeNode cur = null;
			for (Node child : children) {
				TreeNode tNode = new TreeNode(child.val);
				if (head == null) {
					head = tNode;
				} else {
					cur.right = tNode;
				}
				cur = tNode;
				cur.left = en(child.children);
			}
			return head;
		}

		// Decodes your binary tree to an n-ary tree.
		public Node decode(TreeNode root) {
			if (root == null) {
				return null;
			}
			return new Node(root.val, de(root.left));
		}

		public List<Node> de(TreeNode root) {
			List<Node> children = new ArrayList<>();
			while (root != null) {
				Node cur = new Node(root.val, de(root.left));
				children.add(cur);
				root = root.right;
			}
			return children;
		}

	}


	//将多叉树转换为二叉树
	public static TreeNode encode2(Node node) {
		if (node == null) {
			return null;
		}
		//
		TreeNode head = new TreeNode(node.val);
		 head.left = en2(node.children);
		 return head;
	}
	public static TreeNode en2(List<Node> children){
		TreeNode head = new TreeNode(children.get(0).val);
		head.left = en2(children.get(0).children);
		TreeNode cur = head;
		for (int i = 1;i< children.size();i++){
			TreeNode tnode = new TreeNode(children.get(i).val);
			cur.right = tnode;
			cur = tnode;
			cur.left = en2(children.get(i).children);
		}
		return head;
	}


	//将二叉树转换为多叉树
	public static Node decode2(TreeNode root){
		if (root==null){
			return null;
		}
		Node head = new Node(root.val);
		de2(head.children,root.left);
		return head;
	}
	public static Node de2(List<Node> children,TreeNode node){

		Node head = new Node(node.val);
		children.add(head);
		while (node.left!=null){
			de2(children.get(0).children,node.left);
		}

		TreeNode cur = node.right;
		while (cur.right!=null){
			Node thead = new Node(cur.val);
			children.add(thead);
			while (cur.left!=null){
				de2(children.get(children.size()-1).children,node.left);
			}
			cur = cur.right;
		}

		return head;
	}



}
