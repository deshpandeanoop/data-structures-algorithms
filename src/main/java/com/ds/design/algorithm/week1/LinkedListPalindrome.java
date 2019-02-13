package com.ds.design.algorithm.week1;

public class LinkedListPalindrome {

	public static void main(String[] args) {
		int[] a = {1,0,0,1};
		LinkedList l = new LinkedList(a);
		LinkedListPalindrome lp = new LinkedListPalindrome();
		System.out.println(lp.isPalindrome(l.getHead()));
	}
	private boolean isPalindrome(Node head){
		if(null == head || null==head.n){
			return true;
		}
		Node[] t= breakList(head, length(head));
		while(t[0] != null || t[1] != null){
			if(t[0].d != t[1].d){
				return false;
			}
			t[0] = t[0].n;
			t[1] = t[1].n;
		}
		return true;
	}
	private Node[] breakList(Node head,int length){
		int index=0;
		int counter = length/2;
		Node current=head,next=null,prev=null;
		do{
			next = current.n;
			current.n=prev;
			prev = current;
			current = next;
			index++;
		}
		while(index<counter);
		Node[] n = new Node[2];
		n[0] = prev;
		if(length%2!=0){
			current = current.n;
		}
		n[1] = current;
		return n;
	}
	private int length(Node head){
		int counter =0;
		while(head !=null){
			counter++;
			head = head.n;
		}
		return counter;
	}
}
