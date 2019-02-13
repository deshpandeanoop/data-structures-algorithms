package com.ds.design.algorithm.week1;

public class ReverseLinkedList {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		LinkedList ll = new LinkedList(a);
		ReverseLinkedList rev = new ReverseLinkedList();
		ll.print(ll.getHead());
		ll.print(rev.reverseList(ll.getHead()));
		ll.print(ll.getHead());
	}
	private Node reverseList(Node head){
		if(null == head || head.n==null){
			return head;
		}
		Node p=null;
		Node c=head,n=null;
		while(c!=null){
			n=c.n;
			c.n=p;
			p=c;
			c=n;
		}
		return p;
	}

}
