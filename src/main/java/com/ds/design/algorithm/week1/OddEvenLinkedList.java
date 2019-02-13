package com.ds.design.algorithm.week1;

public class OddEvenLinkedList {
	private Node evenHead;
	private Node evenTail;
	private Node oddTail;
	private Node oddHead;
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		LinkedList list = new LinkedList(a);
		OddEvenLinkedList o = new OddEvenLinkedList();
		o.splitList(list.getHead());
		list.print(o.oddHead);
		list.print(o.evenHead);
	}
	private void splitList(Node h){
		int c =1;
		while(h!=null){
			if(c%2==0){
				append(h.d, true);
			}
			else{
				append(h.d, false);
			}
			c++;
			h = h.n;
		}
	}
	private void append(int x, boolean f){
		Node n = new Node(x);
		// Append to even head
		if(f){
			if(evenHead == null){
				evenHead = n;
			}
			else{
				evenTail.n = n;
			}
			evenTail = n;
		}
		// Append to odd head
		else{
			if(oddHead == null){
				oddHead = n;
			}
			else{
				oddTail.n = n;
			}
			oddTail = n;
		}
	}
}
