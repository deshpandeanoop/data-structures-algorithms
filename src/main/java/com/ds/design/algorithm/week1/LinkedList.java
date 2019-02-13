package com.ds.design.algorithm.week1;

public class LinkedList {
	private final int[] data;
	private Node head;
	private Node tail;
	public LinkedList(int[] data) {
		this.data = data;
		createLinkedList();
	}

	private  void createLinkedList() {
		for (Integer x : data) {
			appendNode(x);
		}
	}

	private void appendNode(int d) {
		Node newNode = new Node(d);
		if (head == null) {
			head = newNode;
		} else {
			tail.n = newNode;
		}
		tail = newNode;
	}
	public void print(Node h){
		while(h!=null){
			System.out.print(h.d+"\t");
			h=h.n;
		}
		System.out.println();
	}
	public Node getHead(){
		return head;
	}
}
