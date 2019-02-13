package com.ds.design.algorithm.week2;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.val+"\t");
			head = head.next;
		}
		System.out.println();
	}
}
