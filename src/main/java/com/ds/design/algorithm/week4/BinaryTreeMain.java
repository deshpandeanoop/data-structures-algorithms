package com.ds.design.algorithm.week4;

import java.util.ArrayList;

import org.apache.commons.lang.mutable.MutableInt;

public class BinaryTreeMain {

	public static void main(String[] args) {
		BinaryTree<String> binaryTree = new BinaryTree<>();
		binaryTree.addElement("A");
		binaryTree.addElement("B");
		binaryTree.addElement("C");
		binaryTree.addElement("D");
		binaryTree.addElement("E");
		binaryTree.addElement("F");
		binaryTree.addElement("G");
//		System.out.println("In Order Traversal Recursive : ");
//		binaryTree.inOrderTraversal(binaryTree.getRoot());
//		System.out.println();
//		System.out.println("In Order Traversal Iterative : ");
//		binaryTree.inOrderTraversalIterative(binaryTree.getRoot());
//		System.out.println("Pre Order Traversal :  ");
//		binaryTree.preOrderTraversal(binaryTree.getRoot());
//		System.out.println();
//		System.out.println("Pre Order Traversal Iterative : ");
//		binaryTree.preOrderTraversalIterative(binaryTree.getRoot());
//		System.out.println("Post Order Traversal  :  ");
//		binaryTree.postOrderTraversal(binaryTree.getRoot());
//		MutableInt height = new MutableInt(-1);
//		int pDepth = -1;
//		binaryTree.setHeight(binaryTree.getRoot(), pDepth, height);
//		System.out.println("Height Of the binary tree is : "+height);
//		binaryTree.printAllPaths(binaryTree.getRoot(), new ArrayList<>());
//		System.out.println(binaryTree.isBalanced(binaryTree.getRoot()));
		System.out.println(binaryTree.getDiameter(binaryTree.getRoot(), 0));
	}

}
