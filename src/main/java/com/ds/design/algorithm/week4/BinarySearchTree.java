package com.ds.design.algorithm.week4;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	private Node root;

	public void add(int data) {
		Node newNode = new Node(data);
		if (null == root) {
			root = newNode;
			return;
		}
		Node parent = null;
		Node current = root;
		while (current != null) {

			parent = current;
			if (current.data < data) {
				current = current.right;
			} else if (current.data > data) {
				current = current.left;
			}
		}
		if (parent.data < data) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
	}

	public void inOrderTraversal(Node root) {
		if (null == root) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + "->");
		inOrderTraversal(root.right);
	}

	public List<Integer> getRange(Node root, Node a, Node b) {
		if (null == root || null == a || null == b) {
			return null;
		}
		List<Integer> result = new ArrayList<>();

		int value = a.data;
		Node minNode = getMin(root);
		Node maxNode = getMax(root);
		if (value <= minNode.data) {
			value = minNode.data;
		} else if (value >= maxNode.data) {
			value = maxNode.data;
		} else {
			while (!isPresent(root, value)) {
				value++;
			}
		}

		a.data = value;
		result.add(value);

		Node successor = null;
		while (true) {
			successor = getSuccessor(root, successor);
			if (successor == null | successor.data > b.data) {
				break;
			}
			result.add(successor.data);
		}
		if (successor == null && b.data == maxNode.data) {
			result.add(b.data);
		}
		return result;
	}

	public Node getSuccessor(Node root, Node input) {
		if (null == root || null == input) {
			return null;
		}
		// If input node has right sub tree, then successor is left most child
		// of right sub tree
		if (input.right != null) {
			Node current = root;
			current = current.right;
			while (current.left != null) {
				current = current.left;
			}
			return current;
		}
		// If input node doesn't have right child, then successor is next right
		// parent
		Node successor = null;
		Node current = root;

		while (current != null) {
			if (current.data > input.data) {
				successor = current;
				current = current.left;
			} else if (current.data < input.data) {
				current = current.right;
			} else {
				break;
			}
		}
		return successor;
	}
	public boolean isPresent(Node root, int value){
		if(null == root){
			return false;
		}
		while(root != null){
			if(root.data < value){
				root = root.right;
			}
			else if (root.data > value){
				root = root.left;
			}
			else{
				return true;
			}
		}
		return false;
	}
	
	public Node getMin(Node root){
		if(null == root){
			return root;
		}
		while(root.left != null){
			root = root.left;
		}
		return root;
	}
	
	public Node getMax(Node root){
		if(null == root){
			return root;
		}
		while(root.right != null){
			root = root.right;
		}
		return root;
	}
	public Node buildBalancedBSTUsingSortedArray(int a[], int start, int end){
		if(start > end || start ==a.length || end == -1){
			return null;
		}
		int mid = start + (end-start)/2;
		Node root = new Node(a[mid]);
		root.left = buildBalancedBSTUsingSortedArray(a, start, mid-1);
		root.right = buildBalancedBSTUsingSortedArray(a, mid+1, end);
		return root;
	}
	
	
	public Node getRoot() {
		return this.root;
	}

	// For simplicity, avoiding Generics
	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}
}
