package com.ds.design.algorithm.week4;

import com.ds.design.algorithm.week4.BinarySearchTree.Node;

public class BinarySearchTreeMain {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(2);
		bst.add(1);
		bst.add(3);
		bst.add(8);
		bst.add(6);
		bst.add(7);
		bst.add(11);
	int a [] = {1,2,3,4,5,6,7,8,9};
	Node root = bst.buildBalancedBSTUsingSortedArray(a, 0, a.length);
	System.out.println(root.data);
	}
}
