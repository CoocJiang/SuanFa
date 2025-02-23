package 位运算.class11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Code01_LevelTraversalBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int v) {
			value = v;
		}
	}

	public static Node generateRandomBinaryTree(int depth, int maxValue) {
		if (depth <= 0) {
			return null;
		}

		Random random = new Random();
		Node root = new Node(random.nextInt(maxValue + 1));

		root.left = generateRandomBinaryTree(depth - 1, maxValue);
		root.right = generateRandomBinaryTree(depth - 1, maxValue);

		return root;
	}
	private static void printBinaryTree(Node node, int depth) {
		if (node == null) {
			return;
		}

		// 打印右子树
		printBinaryTree(node.right, depth + 1);

		// 打印当前节点
		for (int i = 0; i < depth; i++) {
			System.out.print("  "); // 打印缩进，表示节点的深度
		}
		System.out.println(node.value); // 打印节点值

		// 打印左子树
		printBinaryTree(node.left, depth + 1);
	}

	public static void level(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
//		Node randomTree = generateRandomBinaryTree(3, 100); // 生成深度为3，节点值最大为100的随机二叉树
		// 可以在这里添加打印或其他操作来验证生成的二叉树
		printBinaryTree(head,0);
//		level(head);
		System.out.println("========");
	}


}


/**
 *
 */
