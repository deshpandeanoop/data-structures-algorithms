package com.ds.design.algorithm.week4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.lang.mutable.MutableInt;

public class BinaryTree<T> {
	private Node<T> root;

	public void addElement(T data) {
		Node<T> newNode = new Node<T>(data);
		if (this.root == null) {
			this.root = newNode;
			return;
		}
		Node<T> root = this.root;
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.remove();
			if (node.left == null) {
				node.left = newNode;
				break;
			}
			if (node.right == null) {
				node.right = newNode;
				break;
			}
			queue.add(node.left);
			queue.add(node.right);
		}
	}

	public void inOrderTraversal(Node<T> root) {
		if (null == root) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + "     |     ");
		inOrderTraversal(root.right);
	}

	public void preOrderTraversal(Node<T> root) {
		if (null == root) {
			return;
		}
		System.out.print(root.data + "     |     ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public void postOrderTraversal(Node<T> root) {
		if (null == root) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + "     |     ");
	}

	public void inOrderTraversalIterative(Node<T> root) {
		if (null == root) {
			return;
		}
		Stack<Node<T>> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			System.out.print(root.data + "     |     ");
			root = root.right;

		}
	}

	public void preOrderTraversalIterative(Node<T> root) {
		if (null == root) {
			return;
		}
		Stack<Node<T>> stack = new Stack<>();
		while (true) {
			while (root != null) {
				System.out.print(root.data + "     |     ");
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			root = root.right;
		}
	}

	public void setHeight(Node<T> root, int pDepth, MutableInt maxDepth) {
		if (null == root) {
			return;
		}
		int nDepth = pDepth + 1;
		if (nDepth > maxDepth.intValue()) {
			maxDepth.setValue(nDepth);
		}
		setHeight(root.left, nDepth, maxDepth);
		setHeight(root.right, nDepth, maxDepth);
	}

	public void printAllPaths(Node<T> root, List<Node<T>> list) {
		if (null == root) {
			return;
		}
		list.add(root);
		if (root.left == null && root.right == null) {
			printList(list);
		} else {
			printAllPaths(root.left, list);
			printAllPaths(root.right, list);
		}
		list.remove(root);
	}

	public int isBalanced(Node<T> root) {
		if (null == root) {
			return 0;
		}
		int left = isBalanced(root.left);
		int right = isBalanced(root.right);
		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	public int getDiameter(Node<T> root, int diameter) {
		if (null == root) {
			return 0;
		}
		int leftHeight = getDiameter(root.left, diameter);
		int rightHeight = getDiameter(root.right, diameter);
		diameter = Math.max(diameter, (leftHeight + rightHeight + 1));
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean isBST(Node<T> root) {
		if (isBinarySearchTree(root) != null) {
			return true;
		}
		return false;
	}

	private Pair isBinarySearchTree(Node<T> root) {
		if (null == root) {
			return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		@SuppressWarnings("unchecked")
		Node<Integer> integerRoot = (Node<Integer>) root;
		Pair left = isBinarySearchTree(root.left);
		Pair right = isBinarySearchTree(root.right);
		if (null == left || null == right) {
			return null;
		}
		if (left.max >= integerRoot.data || right.min <= integerRoot.data) {
			return null;
		}
		int min = integerRoot.left == null ? integerRoot.data : left.min;
		int max = integerRoot.right == null ? integerRoot.data : right.max;

		return new Pair(min, max);

	}

	public static class Pair {
		public int min;
		public int max;

		public Pair(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

	}

	private void printList(List<Node<T>> list) {
		StringBuffer buffer = new StringBuffer();
		for (Node<T> node : list) {
			buffer.append(node.data);
			buffer.append("->");
		}
		System.out.println(buffer.delete(buffer.lastIndexOf("->"), buffer.length()).toString());
	}

	public Node<T> getRoot() {
		return this.root;
	}

	public class Node<R> {
		public Node<R> left;
		public Node<R> right;
		public R data;

		public Node(R data) {
			super();
			this.data = data;
		}

	}
}
